package com.lti.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.*;

@org.springframework.stereotype.Repository
public class RepositoryImpl implements Repository {
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void addBusType(BusType newBus) {
		System.out.println(entityManager);
		entityManager.persist(newBus);
	}

	@Transactional
	public void updateBusStatus(String busName, String busStatus) {
		BusType busType = entityManager.find(BusType.class, busName);
		busType.setBusStatus(busStatus);
		entityManager.merge(busType);
	}

	@Transactional
	public void deleteBus(String busName) {
		BusType busType = entityManager.find(BusType.class, busName);
		entityManager.remove(busType);
	}

	@Transactional
	public BusType getBusType(String busName) {
		BusType busType = entityManager.find(BusType.class, busName);
		return busType;
	}

	@Transactional
	public void addBusDetails(BusDetails busObj) {
		entityManager.persist(busObj);
	}

	@Transactional
	public void deleteBusDetails(int routeNo) {
		BusDetails busDetails = entityManager.find(BusDetails.class, routeNo);
		entityManager.remove(busDetails);
	}

	@Transactional
	public void updateBusDetails(int routeNo, String busName) {
		BusDetails busDetails = entityManager.find(BusDetails.class, routeNo);
		BusType busType = entityManager.find(BusType.class, busName);
		busDetails.setNewBusName(busType);
		entityManager.merge(busDetails);
	}

	@Transactional
	public BusDetails getBus(int routeNo) {
		BusDetails busDetails = entityManager.find(BusDetails.class, routeNo);
		return busDetails;
	}

	@Transactional
	public void addRoute(BusRoute newRoute) {
		entityManager.persist(newRoute);
	}

	@Transactional
	public void deleteRoute(int pathNo) {
		BusRoute route = entityManager.find(BusRoute.class, pathNo);
		entityManager.remove(route);
	}

	@Transactional
	public List<String[]> searchBus(String src, String dest) {
		// TODO Auto-generated method stub
		//pathNo src dest routeNo distance startTime reachedTime fare busNo busName bustYpe busStatus
		String hql = "SELECT R.pathNo FROM BusRoute R WHERE R.source =:src and R.destination=:dest";
		Query query = entityManager.createQuery(hql);
		query.setParameter("src",src);
		query.setParameter("dest", dest);
		List<Integer> paths = query.getResultList();
		List<String[]> availableBus = new ArrayList<String[]>();
		for(int path:paths) {
			BusRoute busRoute = entityManager.find(BusRoute.class, path);
			String[] str = new String[12];
			str[0]=""+path;
			str[1]=busRoute.getSource();
			str[2]=busRoute.getDestination();
			str[3]=""+busRoute.getNewBusDetails().getRouteNo();
			str[4]=""+busRoute.getDistance();
			str[5]=busRoute.getStartTime();
			str[6]=busRoute.getReachTime();
			str[7]=""+busRoute.getFare();
			str[8]=""+busRoute.getBusNo();
			str[9]=busRoute.getNewBusDetails().getNewBusName().getBusName();
			str[10]=busRoute.getNewBusDetails().getNewBusName().getType();
			str[11]=busRoute.getNewBusDetails().getNewBusName().getBusStatus();
			availableBus.add(str);
		}
		return availableBus;
	}

	@Transactional
	public BusRoute getRouteDetails(int pathNo) {
		BusRoute route = entityManager.find(BusRoute.class, pathNo);
		return route;
	}

	@Transactional
	public void addUnAuthorizedUser(String Email, String PhoneNo) {
		UnAuthorized unAuthorize = new UnAuthorized();
		unAuthorize.setEmail(Email);
		unAuthorize.setPhone(PhoneNo);
		entityManager.persist(unAuthorize);
	}
	
	
	@Transactional
	public void addUnAuthorizedUser(Reservation res,String Email, String PhoneNo) {
		UnAuthorized unAuthorize = new UnAuthorized();
		unAuthorize.setNewReservation(res);
		unAuthorize.setEmail(Email);
		unAuthorize.setPhone(PhoneNo);
		entityManager.merge(unAuthorize);
	}

	@Transactional
	public void addRegistration(Registration newRegister) {
		entityManager.persist(newRegister);
	}

	@Transactional
	public void updateBookedTicket(String email, int noOfTicket) {
		Registration registerObj = entityManager.find(Registration.class, email);
		int curNoOfTicket = registerObj.getNoOfBookedTicket();
		registerObj.setNoOfBookedTicket(curNoOfTicket+noOfTicket);
		entityManager.merge(registerObj);
	}

	//May be a part of Service Layer
	@Transactional
	public double getWallet(String email) {
		Registration registerObj = entityManager.find(Registration.class, email);
		double currentAmount = registerObj.getWallet();
		return currentAmount;
	}

	@Transactional
	public void updateWallet(String email, double amount) {
		
		Registration registerObj = entityManager.find(Registration.class, email);
		registerObj.setWallet(amount);
		entityManager.merge(registerObj);
	}

	@Transactional
	public void updateUserDetails(String email, Date dob, String gender) {
		Registration registerObj = entityManager.find(Registration.class, email);
		registerObj.setDateOfBirth(dob);
		registerObj.setGender(gender);
		entityManager.merge(registerObj);
	}

	@Transactional
	public String updatePassword(String email) {
		Registration registerObj = entityManager.find(Registration.class, email);
		return registerObj.getPassword();
	}

	@Transactional
	public void forgotPassword(String email, String newPassword) {
		Registration registerObj = entityManager.find(Registration.class, email);
		registerObj.setPassword(newPassword);
		entityManager.merge(registerObj);
	}

	@Transactional
	public List<Registration> noBookedTicket() {
		String hql = "FROM Registration R WHERE R.noOfBookedTicket = :count";
		Query query = entityManager.createQuery(hql);
		query.setParameter("count",0);
		List results = query.getResultList();
		return results;
	}

	@Transactional
	public String login(String emailId) {
		Registration registerObj = entityManager.find(Registration.class, emailId);
		return registerObj.getPassword();
	}

	@Transactional
	public double walletBalance(String email) {
		Registration registerObj = entityManager.find(Registration.class, email);
		return registerObj.getWallet();
	}

	@Transactional
	public Registration userRegistrationDetails(String email) {
		Registration registerObj = entityManager.find(Registration.class, email);
		return registerObj;
	}

	//need to be checked
	@Transactional
	public void addUserTicket(Registration reg, Reservation res) {
		RegisteredUserTicket newTicket = new RegisteredUserTicket();
		newTicket.setRegister(reg);
		newTicket.setNewRegTic(res);
		entityManager.merge(newTicket);
	}

	@Transactional
	public List<String[]> allBookedTicket() {
		//source dest doj fare  email ticketStatus
		List<String[]>  allTickets = new ArrayList<String[]>();
		String hql = "FROM RegisteredUserTicket";
		Query query = entityManager.createQuery(hql); 
		List<RegisteredUserTicket> results = query.getResultList();
		List<String[]> tickets= new ArrayList<String[]>();
		for(RegisteredUserTicket res : results) {
				String[] stringObj = new String[6];
				stringObj[0]=res.getNewRegTic().getNewRoute().getSource();
				stringObj[1]=res.getNewRegTic().getNewRoute().getDestination();
				Date date = res.getNewRegTic().getDateOfJourney(); 
		        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
				stringObj[2]=dateFormat.format(date);
				stringObj[3]=""+res.getNewRegTic().getNewRoute().getFare();
				stringObj[4]=res.getRegister().getEmail();
				stringObj[5]=res.getNewRegTic().getTicketStatus();
				tickets.add(stringObj);
		}
		return tickets;
	}

	@Transactional
	public void addReservation(Reservation obj) {
		// TODO Auto-generated method stub
		entityManager.persist(obj);
	}

	@Transactional
	public void update(int ticketNo, String status, Date cancelDate, double refundAmt) {
		// TODO Auto-generated method stub
		Reservation res= entityManager.find(Reservation.class, ticketNo);
		res.setTicketStatus(status);
		res.setCancellationDate(cancelDate);
		res.setRefundAmount(refundAmt);
		entityManager.merge(res);
		
	}

	@Transactional
	public String[] frequentTravelRoute() {
		// TODO Auto-generated method stub
		String hql= "SELECT r.newRoute from Reservation r";
		Query query=entityManager.createQuery(hql);
		List<BusRoute> paths= query.getResultList();
		HashMap<String[],Integer> frequent = new HashMap<String[],Integer>();
		for(BusRoute i:paths) {
			String[] str = new String[2];
			str[0]=i.getSource();
			str[1]=i.getDestination();
			if(frequent.containsKey(str)) {
				int k = frequent.get(str);
				k++;
				frequent.put(str, k);
			}else {
				frequent.put(str, 1);
			}
		}
		Set<String[]> keySet = frequent.keySet();
		int maxCount=0;
		String[] mostFrequentRoute=new String[2];
		for(String[] route:keySet) {
			if(frequent.get(route)>maxCount) {
				maxCount=frequent.get(route);
				mostFrequentRoute[0]=route[0];
				mostFrequentRoute[1]=route[1];
			}
		}
		return mostFrequentRoute;
	}

	@Transactional
	public double lastMonthProfit(Date date1, Date date2) {
		// TODO Auto-generated method stub
		String hql= "SELECT r.newRoute from Reservation r where r.dateOfJourney between :dt1 AND :dt2";
		Query query=entityManager.createQuery(hql);
		query.setParameter("dt1", date1);
		query.setParameter("dt2", date2);
		List<BusRoute> paths= query.getResultList();
		double totalProfit=0;
		for(BusRoute path: paths) {
			totalProfit+=path.getFare();
		}
		return totalProfit;	
		
	}

	@Transactional
	public int mostPreferredBus() {
		// TODO Auto-generated method stub
		String hql= "SELECT r.newRoute from Reservation r";
		Query query=entityManager.createQuery(hql);
		List<BusRoute> paths= query.getResultList();
		HashMap<Integer,Integer> frequent = new HashMap<Integer,Integer>();
		for(BusRoute i:paths) {
			if(frequent.containsKey(i.getBusNo())) {
				int k = frequent.get(i.getBusNo());
				k++;
				frequent.put(i.getBusNo(), k);
			}else {
				frequent.put(i.getBusNo(), 1);
			}
		}
		Set<Integer> keySet = frequent.keySet();
		int maxCount=0;
		int mostFrequentBus=0;
		for(int i:keySet) {
			if(frequent.get(i)>maxCount) {
				maxCount=frequent.get(i);
				mostFrequentBus=i;
			}
		}
		return mostFrequentBus;
	}

	@Transactional
	public List<Reservation> dailyBooked(Date date) {
		// TODO Auto-generated method stub
		String hql="from Reservation where dateOfJourney=: dt";
		Query query=entityManager.createQuery(hql);
		query.setParameter("dt", date);
		List<Reservation> res= query.getResultList();
		return res;
	}
	
	@Transactional
	public List<Reservation> weeklyBooked(Date date1, Date date2) {
		// TODO Auto-generated method stub
		String hql="from Reservation r where r.dateOfJourney between :dt1 AND :dt2";
		Query query=entityManager.createQuery(hql);
		query.setParameter("dt1", date1);
		query.setParameter("dt2", date2);
		List<Reservation> res= query.getResultList();
		return res;
	}
	
	@Transactional
	public List<Reservation> monthlyBooked(Date date1, Date date2) {
		// TODO Auto-generated method stub
		String hql="from Reservation r where r.dateOfJourney between :dt1 AND :dt2";
		Query query=entityManager.createQuery(hql);
		query.setParameter("dt1", date1);
		query.setParameter("dt2", date2);
		List<Reservation> res= query.getResultList();
		return res;
	}
	
	@Transactional
	public List<String[]> availableSeats() {
		// TODO Auto-generated method stub
		//ticketNo seatno ticketStatus src dest routeNo
		String hql = "FROM Reservation"; 
		Query query = entityManager.createQuery(hql); 
		List<Reservation> paths = query.getResultList();
		List<String[]> allSeat = new ArrayList<String[]>();
		for(Reservation res:paths) {
			BusRoute busRoute = entityManager.find(BusRoute.class, res.getNewRoute().getPathNo());
			String[] str = new String[7];
			Date date = res.getDateOfJourney(); 
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
			str[0]=	dateFormat.format(date);
			str[1]=""+res.getTicketNo();
			str[2]=""+res.getSeatNo();
			str[3]=res.getTicketStatus();
			str[4]=busRoute.getSource();
			str[5]=busRoute.getDestination();
			str[6]=""+busRoute.getNewBusDetails().getRouteNo();
			allSeat.add(str);
		}
		return allSeat;
	}

	@Transactional
	public String[] searchTicket(int ticketNo) {
		// TODO Auto-generated method stub
		Reservation res= entityManager.find(Reservation.class, ticketNo);
		
		//Date date1 = res.getDateOfJourney(); 
		//Date date2 = res.getBookingDate(); 
        //DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy"); 
		//dateFormat.format(date1);
        
		String[] str=new String[10];
		str[0]=""+res.getBookingDate(); //booking date
		str[1]=	""+res.getDateOfJourney();//date of journey
		str[2]=""+res.getTicketNo();
		str[3]=""+res.getSeatNo();
		str[4]=""+res.getNewRoute().getBusNo();
		str[5]=res.getNewRoute().getSource();
		str[6]=res.getNewRoute().getDestination();
		str[7]=""+res.getNewRoute().getFare();
		str[8]=res.getNewRoute().getStartTime();
		str[9]=res.getNewRoute().getReachTime();
		return str;

	}
	@Transactional
	public void cancelTicket(int ticketNo, Date cancelDate) {
		// TODO Auto-generated method stub
		Reservation res= entityManager.find(Reservation.class, ticketNo);
		res.setTicketStatus("cancel");
		res.setRefundAmount(res.getNewRoute().getFare());
		res.setCancellationDate(cancelDate);
		entityManager.merge(res);
	}

	@Transactional
	public Reservation getReservation(int ticketNo) {
		Reservation resObj = entityManager.find(Reservation.class, ticketNo);
		return resObj;
	}
	

}
