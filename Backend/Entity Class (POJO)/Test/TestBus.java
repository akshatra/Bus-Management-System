package com.lti;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.lti.util.BaseDAO;

public class TestBus {

	@Test
	public void testCase1() {
		BusType newBusType = new BusType();
		newBusType.setBusName("DeepMala");
		newBusType.setBusStatus("Active");
		newBusType.setType("Driver");
		
		BusDetails newBusDetails = new BusDetails();
		newBusDetails.setRouteNo(1);
		newBusDetails.setNewBusName(newBusType);
		
		Set<BusDetails> obj1 = new HashSet<BusDetails>();
		obj1.add(newBusDetails);
		
		newBusType.setNewBusDetails(obj1);
		
	    BaseDAO baseDAO = new BaseDAO();
	    baseDAO.persist(newBusType);
	}
	
	@Test
	public void testCase2() {
		BusType newBusType = new BusType();
		newBusType.setBusName("Durga");
		newBusType.setBusStatus("ACTIVE");
		newBusType.setType("DRIVERLESS");
		
		BaseDAO baseDAO = new BaseDAO();
	    baseDAO.persist(newBusType);
	}
	
	@Test
	public void testCase3() {
		BaseDAO baseDAO = new BaseDAO();
		BusDetails newBusDetails = new BusDetails();
		BusType busType= baseDAO.find(BusType.class, "Durga");
		newBusDetails.setRouteNo(2);
		newBusDetails.setNewBusName(busType);
		
	    baseDAO.merge(newBusDetails);
	}
	
	@Test
	public void testCase4() {
		BusRoute newRoute = new BusRoute();
		newRoute.setBusNo(101);
		newRoute.setSource("Supaul");
		newRoute.setDestination("Patna");
		newRoute.setDistance(200);
		newRoute.setFare(newRoute.getDistance()*10);
		
		BaseDAO baseDAO = new BaseDAO();
	    baseDAO.persist(newRoute);
	}
	/*
	@Test
	public void testCase5() {
		BaseDAO baseDAO = new BaseDAO();
	    BusType obj1 = baseDAO.find(BusType.class,"DeepMala");
	    System.out.println("Bus Name : " + obj1.getBusName());
	    System.out.println("Bus Status : " + obj1.getBusStatus());
	    System.out.println("Bus Type : " + obj1.getType());
	    
	    BusDetails obj2 = baseDAO.find(BusDetails.class, 2);
	    System.out.println("Route No : " + obj2.getRouteNo());
	    
	    
	    obj2.setNewBusName(obj1);
	    
	    baseDAO.merge(obj2);
	}
	
	
	@Test
	public void testCase6() {
		BaseDAO baseDAO = new BaseDAO();
		
		Reservation newReservation = new Reservation();
		newReservation.setDateOfJourney(null);
		newReservation.setSeatNo(5);
		newReservation.setTicketStatus("Booked");
		
		BusRoute obj1 = baseDAO.find(BusRoute.class, 1);
		System.out.println(obj1.getBusNo());
		newReservation.setNewRoute(obj1);
		
		baseDAO.persist(newReservation);
	}
	
	@Test
	public void testCase7() {
		BaseDAO baseDAO = new BaseDAO();
		Reservation obj1 = baseDAO.find(Reservation.class, 2);
		System.out.println("==============================");
		System.out.println("Ticket no : " + obj1.getTicketNo());
		System.out.println("Seat no : " + obj1.getSeatNo());
		System.out.println("Ticket Status : " +obj1.getTicketStatus());
		System.out.println("==============================");
	}
	
	@Test
	public void testCase8() {
		BaseDAO baseDAO = new BaseDAO();
		Reservation obj1 = new Reservation();
		obj1.setTicketStatus("booked");
		obj1.setSeatNo(15);
		baseDAO.persist(obj1);
	}
	
	@Test
	public void testCase9() {
		BaseDAO baseDAO = new BaseDAO();
		UnAuthorized newUnAuthorized = new UnAuthorized();
		newUnAuthorized.setEmail("rajan@gmail.com");
		
		Reservation obj1 = new Reservation();
		obj1.setTicketStatus("booked");
		obj1.setSeatNo(11);
		obj1.setNewUnAuthorized(newUnAuthorized);
		
		
		newUnAuthorized.setNewReservation(obj1);
		baseDAO.persist(newUnAuthorized);
	}
	
	@Test
	public void testCase10() {
		BaseDAO baseDAO = new BaseDAO();
		UnAuthorized newUnAuthorized = new UnAuthorized();
		newUnAuthorized.setEmail("rajan@gmail.com");
		
		Reservation obj1 = baseDAO.find(Reservation.class, 17);
		obj1.setNewUnAuthorized(newUnAuthorized);
		
		
		newUnAuthorized.setNewReservation(obj1);
		baseDAO.merge(newUnAuthorized);
	}
	
	@Test
	public void testCase11() {
		BaseDAO baseDAO = new BaseDAO();
		Registration newObj = new Registration();//
		newObj.setEmail("Keshav@gmail.com");
		newObj.setFirstName("Rishav");
		newObj.setLastName("Mishra");
		newObj.setPassword("Keshav123");
		
		RegisteredUserTicket newObj1 = new RegisteredUserTicket();
	    newObj1.setRegister(newObj);
	    
	    
	    Set<RegisteredUserTicket> obj1 = new HashSet<RegisteredUserTicket>();
	    obj1.add(newObj1);
	    
	    newObj.setRegisterTicket(obj1);
		baseDAO.persist(newObj);
		
	
		
	}
	
	@Test
	public void testCase12() {
		BaseDAO baseDAO = new BaseDAO();
		Registration newRegistration = baseDAO.find(Registration.class, "Keshav@gmail.com");
		System.out.println(newRegistration.getEmail());
		System.out.println(newRegistration.getFirstName()+newRegistration.getLastName());
		System.out.println(newRegistration.getPassword());
		
		//baseDAO.persist(newUser);
	}
	
	@Test
	public void testCase13() {
		BaseDAO baseDAO = new BaseDAO();
		Reservation obj1 = baseDAO.find(Reservation.class, 38);
		
		RegisteredUserTicket obj2 = new RegisteredUserTicket();
		obj2.setNewRegTic(obj1);
		baseDAO.merge(obj2);
	}
	*/
}
