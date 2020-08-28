package com.lti.repo;

import java.util.Date;
import java.util.List;

import com.lti.entity.*;

public interface Repository {
	
	//Bus_Type Table Operations
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
			public List<String[]> searchBus(String src, String dest);               // Need to return list of bus_Details
			public BusRoute getRouteDetails(int pathNo);

			//UnAuthorized Table
			public void addUnAuthorizedUser(Reservation res, String Email, String PhoneNo);  //no need of ticketNo here
			//public void updateUnAuthorized(Reservation res, UnAuthorized unAuthorized);
			//Register Table
			public void addRegistration(Registration newRegister);
			public void updateBookedTicket(String email, int noOfTicket);
			public double getWallet(String email);
			public void updateWallet(String email, double amount);
			public void updateUserDetails(String email, Date dob, String gender);
			public String updatePassword(String email);
			public void forgotPassword(String email, String newPassword);
			public List<Registration> noBookedTicket();
			public String login(String emailId);
			public double walletBalance(String email);
			public Registration userRegistrationDetails(String email);

			//Registered_User_Ticket Table
			public void addUserTicket(Registration reg, Reservation res);
			public List<String[]> allBookedTicket();  //Dashboard functionality(bookings)

			//Reservation Table
			public void addReservation(Reservation obj);
			public void update(int ticketNo, String status, Date cancelDate, double refundAmt);
			public String[] frequentTravelRoute(); // return pathNo
			public double lastMonthProfit(Date date1, Date date2);
			public int mostPreferredBus();
			public List<Reservation> dailyBooked(Date date); //return all current day bookings
			public List<Reservation> weeklyBooked(Date date1, Date date2);
			public List<String[]> availableSeats();
			public String[] searchTicket(int ticketNo);
			public void cancelTicket(int ticketNo, Date cancelDate);
			public Reservation getReservation(int ticketNo);
}
