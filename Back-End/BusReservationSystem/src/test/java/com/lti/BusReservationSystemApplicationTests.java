package com.lti;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.entity.BusDetails;
import com.lti.entity.BusRoute;
import com.lti.entity.BusType;
import com.lti.entity.Registration;
import com.lti.entity.Reservation;
import com.lti.exception.BusServiceException;
import com.lti.repo.Repository;
import com.lti.service.ProjectService;

@SpringBootTest
class BusReservationSystemApplicationTests {
	@Autowired
	Repository obj;

	@Autowired
	ProjectService prj;
	
	@Test
	void contextLoads() {
		BusType newBus = new BusType();
		newBus.setBusName("DeepMala");
		newBus.setBusStatus("Status");
		newBus.setType("Driverless");
		
		obj.addBusType(newBus);
	}
	@Test
	void contextLoads1() {
		try {
			prj.updateBusStatus("ShivaJi", "Active");
		} catch (Exception e) {
			System.out.println("Message: "+e.getMessage());
		}
		
	}
	
	@Test
	void contextLoads2() {
		obj.deleteBus("DeepMala");		
	}
	
	@Test
	void contextLoads3() {
		try {
			BusType newBus = new BusType();
			newBus= prj.getBusType("RajRa");	
			System.out.println("BusName : " + newBus.getBusName());
			System.out.println("Bus Status : " + newBus.getBusStatus());
			System.out.println("BusType : " + newBus.getType());
		} catch (Exception e) {
			System.out.println("Message : "+e.getMessage());
		}
	}
	
	@Test    //add bus details
	void contextLoads4() {
		BusType newBus = new BusType();
		newBus.setBusName("RajRath");
		newBus.setBusStatus("Status");
		newBus.setType("Driver");
		
		BusDetails busDetails=new BusDetails();
		busDetails.setRouteNo(5);
		busDetails.setNewBusName(newBus);
		obj.addBusType(newBus);
		obj.addBusDetails(busDetails);
	}
	
	@Test
	void contextLoads5() {
		obj.deleteBusDetails(1);			
	}
	

	@Test
	void contextLoads6() {
		obj.updateBusDetails(1, "Rajrath");			
	}
	
	@Test
	void contextLoads7() {					
		try {
			BusDetails busDetails= prj.getBus(100);
			System.out.println(busDetails.getNewBusName().getBusName());
			System.out.println(busDetails.getRouteNo());
		} catch (Exception e) {
			System.out.println("Message : "+e.getMessage());
		}
	}
	

	@Test
	void contextLoads8() {
		BusRoute busRoute = new BusRoute();
		busRoute.setBusNo(101);
		busRoute.setSource("Pune");
		busRoute.setDestination("Dombivli");
		busRoute.setDistance(100);
		busRoute.setFare(500);
		busRoute.setReachTime("09:00");
		busRoute.setStartTime("07:00");
		
		BusDetails busDetails= obj.getBus(1);
		
		busRoute.setNewBusDetails(busDetails);
		obj.addRoute(busRoute);
	}
	

	@Test
	void contextLoads9() {
		try {
			prj.deleteRoute(500);
		} catch (Exception e) {
			System.out.println("Message : " + e.getMessage());
		}
	}
	
	@Test
	void contextLoads10() {
		BusRoute busRoute=obj.getRouteDetails(22);
		System.out.println(busRoute.getBusNo());
		System.out.println(busRoute.getSource());
		System.out.println(busRoute.getDestination());
		System.out.println(busRoute.getStartTime());
		System.out.println(busRoute.getReachTime());
		System.out.println(busRoute.getFare());
	}
	
	
	@Test				
	void contextLoads11() {
		Reservation res = obj.getReservation(56);
		obj.addUnAuthorizedUser(res,"anand@gmail.com", "8406807728");
	}
	
	@Test			
	void contextLoads12() {
		try {
			Registration regis=new Registration();
			regis.setEmail("Aryan@gmail.com");
			regis.setFirstName("Aryan");
			regis.setLastName("Raj");
			regis.setPassword("Aryan123");
			regis.setPhone("9862821305");
			prj.addRegistration(regis);
		} catch (Exception e) {
			System.out.println("Message : "+e.getMessage());
		}
	}
	

	@Test			
	void contextLoads13() {
		obj.updateBookedTicket("garghimanshu76@gmail.com",4);
	}
	
	@Test			
	void contextLoads14() {
		int a= (int) obj.getWallet("garghimanshu76@gmail.com");
		System.out.println(a);
	}
	
	
	@Test			
	void contextLoads16() {
		String pass=obj.updatePassword("garghimanshu76@gmail.com");
		System.out.println(pass);
	}

	@Test		
	void contextLoads17() {
		obj.forgotPassword("garghimanshu76@gmail.com", "Upes@123");
	}
	
	@Test		
	void contextLoads18() {
		
		List<Registration> str= obj.noBookedTicket();
		for(Registration i: str) {
			System.out.println(i.getEmail());
		}
	}
	
	@Test		
	void contextLoads19() {
		String pass=obj.login("garghimanshu76@gmail.com");
		System.out.println(pass);
	}
	
	@Test		
	void contextLoads20() {
		double money=obj.walletBalance("garghimanshu76@gmail.com");
		System.out.println(money);
	}
	
	@Test		
	void contextLoads21() {
		Registration regis= obj.userRegistrationDetails("Anupam@gmail.com");
		System.out.println(regis.getFirstName());
		System.out.println(regis.getEmail());
		System.out.println(regis.getLastName());
		System.out.println(regis.getPhone());
	}
	
	@Test		
	void contextLoads22() {
		obj.updateWallet("Anupam@gmail.com", 1000);
	}
	@Test		
	void contextLoads23() throws java.text.ParseException, ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        java.sql.Date sqlDate = null;
        java.sql.Date sqlDate1 = null;
        String date = "05-10-2020";
        if( !date.isEmpty()) {
             java.util.Date normalDate = sdf1.parse(date);
			 sqlDate = new java.sql.Date(normalDate.getTime());
         }
        BusRoute busRoute=obj.getRouteDetails(1);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        Date date1 =cal.getTime();
        String dt1 =  sdf1.format(date1); 
        if( !dt1.isEmpty()) {
            try {
                java.util.Date normalDate = sdf1.parse(dt1);
                sqlDate1 = new java.sql.Date(normalDate.getTime());
            } catch (ParseException e) {
               
            }
        }
	     	Reservation res=new Reservation();
			res.setSeatNo(15);
			res.setTicketStatus("booked");
			res.setDateOfJourney(sqlDate);
			res.setBookingDate(sqlDate1);
			res.setNewRoute(busRoute);
			obj.addReservation(res);
		   }
	
	@Test		
	void contextLoads25() {			
		//double i= obj.lastMonthProfit();
		//System.out.println("Profit : " + i);
	}
	
	@Test		
	void contextLoads26() {			
		int i= obj.mostPreferredBus();
		System.out.println("Bus : " + i);
	}
	
	@Test		
	void contextLoads27() {			
		String[] str= obj.frequentTravelRoute();
		System.out.println("Source : " + str[0]);
		System.out.println("Destination : " + str[1]);
	}
	
	@Test		
	void contextLoads28() {		
		Registration regis= obj.userRegistrationDetails("Keshav@gmail.com");
		
		Reservation reserve = obj.getReservation(71);
		
		obj.addUserTicket(regis,reserve);
	}
	
	@Test		
	void contextLoads29() {			
		List<String[]> availableBuses = obj.searchBus("Navi Mumbai","Dombivli");
		for(String[] bus:availableBuses) {
			for(int i=0;i<bus.length;i++) {
				System.out.println(bus[i]);
			}
		}
	}
	
	@Test		
	void contextLoads30() {			
		List<String[]> availableBuses = obj.availableSeats();
		for(String[] bus:availableBuses) {
			for(int i=0;i<bus.length;i++) {
				System.out.println(bus[i]);
			}
		}
	}
	
	@Test		
	void contextLoads31() {			
		List<String[]> availableBuses = obj.allBookedTicket();
		for(String[] bus:availableBuses) {
			for(int i=0;i<bus.length;i++) {
				System.out.println(bus[i]);
			}
		}
	}
	
	@Test
	void contextLoads32() {
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			java.sql.Date sqlDate = null;
			String date = "05-10-2020";
			if( !date.isEmpty()) {
			     try {
			         java.util.Date normalDate = sdf1.parse(date);
			         sqlDate = new java.sql.Date(normalDate.getTime());
			     } catch (ParseException e) {
			        
			     }
			 }
			List<Integer> list = prj.availableSeats(101,""+sqlDate,"Pune", "Dombivli");
			for(int i: list) {
				System.out.println("Hello : "+i);
			}
		} catch (BusServiceException e) {
			System.out.println("Message : " + e.getMessage());
		}
	}
	
	@Test
	void contextLoads33() {
		try {
			List<String[]> availableBuses = prj.searchBus("Mumbai","Dombivli", "10:00","15:15", "authorized");
			if(availableBuses.size()>0) {
				for(String[] bus:availableBuses) {
					for(int i=0;i<bus.length;i++) {
						System.out.println(bus[i]);
					}
				}
			}else {
				System.out.println("No BUS FOUND");
			}
		} catch (BusServiceException e) {
			System.out.println("Message : " + e.getMessage());
		}
	}
	
	@Test		
	void contextLoads34() {			
		try {
			prj.updateWallet("Keshav@gmail.com", -1200);
		} catch (BusServiceException e) {
			System.out.println("Message : " + e.getMessage());
		}
	}
	
	@Test		
	void contextLoads35() {			
		prj.updatePassword("Keshav@gmail.com", "Keshav123","Keshav1234");
	}
	
	
	@Test		
	void contextLoads36() {			
		List<String[]> availableBuses = prj.allBookedTicket("Keshav@gmail.com");
		for(String[] bus:availableBuses) {
			for(int i=0;i<bus.length;i++) {
				System.out.println(bus[i]);
			}
		}
	}
	
	@Test		
	void contextLoads37() {			
		System.out.println("Total Profit: " + prj.lastMonthProfit());
	}
	
	@Test		
	void contextLoads38() {			
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        java.sql.Date sqlDate = null;
        String date = "2020-10-05";
        if( !date.isEmpty()) {
             try {
                 java.util.Date normalDate = sdf1.parse(date);
                 sqlDate = new java.sql.Date(normalDate.getTime());
             } catch (ParseException e) {
                
             }
         }
		List<Integer> list = prj.availableSeats(101, date,"Pune", "Navi Mumbai");
		for(int i: list) {
			System.out.println("Hello : "+i);
		}
	}
	
	
	@Test		
	void contextLoads39() {			
		try {
			prj.cancelTicket(50, "Keshav@gmail.com");
		} catch (Exception e) {
			System.out.println("Message : " + e.getMessage());
		}
	}
	
	@Test		
	void contextLoads40() {			
		try {
			prj.updateBusDetails(2, "DeepMala");
		} catch (Exception e) {
			System.out.println("Message : " + e.getMessage());
		}
	}
	
	@Test
	void contextLoads41() {
		try {
			System.out.println(prj.login("Keshav@gmail.com", "Keshav123"));
		} catch (Exception e) {
			System.out.println("Message : " + e.getMessage() + " "+e.getClass().getName());
		}
	}
	
	@Test
	void contextLoads42() {
		try {
			String[] str = prj.searchTicket(71);
			for(String i:str) {
				System.out.println(i);
			}
		} catch (Exception e) {
			System.out.println("Message : " + e.getMessage() + " "+e.getClass().getName());
		}
	}
	
}