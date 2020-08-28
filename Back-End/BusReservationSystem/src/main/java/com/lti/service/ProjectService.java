package com.lti.service;

import java.util.Date;
import java.util.List;

import com.lti.entity.BusDetails;
import com.lti.entity.BusRoute;
import com.lti.entity.BusType;
import com.lti.entity.Registration;
import com.lti.entity.Reservation;



public interface ProjectService {
	public void addBusType(BusType newBus);
	public void updateBusStatus(String busName, String busStatus);
	public void deleteBus(String busName);
	public BusType getBusType(String busName);
	
	//Bus_Details_table
	public void addBusDetails(BusDetails busObj);
	public void deleteBusDetails(int routeNo);
	public void updateBusDetails(int routeNo,String busName);
	public BusDetails getBus(int routeNo);
	
	//Route Table
	public void addRoute(BusRoute newRoute);
	public void deleteRoute(int pathNo);
	public List<String[]> searchBus(String src, String dest, String fromTime, String toTime, String typeOfUser);               // Need to return list of bus_Details
	public BusRoute getRouteDetails(int pathNo);

	//UnAuthorized Table
	public void addUnAuthorizedUser(Reservation res, String Email, String PhoneNo);
	
	//Register Table
	public void addRegistration(Registration newRegister);
	public void updateBookedTicket(String email, int noOfTicket);
	public double getWallet(String email);
	public void updateWallet(String email, double amount);
	public void updateUserDetails(String email, Date dob, String gender);
	public void updatePassword(String email, String oldPassword, String newPassword);
	public void forgotPassword(String email, String newPassword);
	public List<Registration> noBookedTicket();
	public String login(String emailId,String password);
	public double walletBalance(String email);
	public Registration userRegistrationDetails(String email);
	//Registered_User_Ticket Table
	//public void addUserTicket(Reservation resObj, Registration registerObj);
	public void addUserTicket(Registration reg, Reservation res);
	public List<String[]> allBookedTicket(String emailId);  //Dashboard functionality(bookings)

	//Reservation Table
	public void addReservation(Reservation obj);
	public void update(int ticketNo, String status, Date cancelDate, double refundAmt);
	public String[] frequentTravelRoute(); // return pathNo
	public double lastMonthProfit();
	public int mostPreferredBus();
	public List<Reservation> dailyBooked(Date date); //return all current day bookings
	public List<Reservation> weeklyBooked(Date date1, Date date2);
	public List<Integer> availableSeats(int busNo, String doj,String src, String dest);
	public String[] searchTicket(int ticketNo);
	public void cancelTicket(int ticketNo, String email);
	public Reservation getReservation(int ticketNo);
	
	//print ticket
	public void printTicket();
}
