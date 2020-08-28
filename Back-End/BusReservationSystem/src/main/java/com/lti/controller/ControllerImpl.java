package com.lti.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AllBookedTicket;
import com.lti.dto.AvailableSeatsDto;
import com.lti.dto.BusDetailsDto;
import com.lti.dto.BusOutput;
import com.lti.dto.CancelTicketDto;
import com.lti.dto.DeleteBusDetailsDto;
import com.lti.dto.DeleteBusDto;
import com.lti.dto.ForgotPassDto;
import com.lti.dto.GetBusTypeDto;
import com.lti.dto.LoginDto;
import com.lti.dto.ResDto;
import com.lti.dto.SearchBookedTicket;
import com.lti.dto.SearchDto;
import com.lti.dto.SearchTicketdto;
import com.lti.dto.SeatsFindDto;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.dto.UpdateDto;
import com.lti.dto.UpdatePassword;
import com.lti.dto.UserDetails;
import com.lti.dto.WalletBalance;
import com.lti.entity.BusDetails;
import com.lti.entity.BusRoute;
import com.lti.entity.BusType;
import com.lti.entity.Registration;
import com.lti.entity.Reservation;
import com.lti.exception.BusServiceException;
import com.lti.service.ProjectService;
import com.sun.mail.util.MailConnectException;

@RestController
@CrossOrigin
public class ControllerImpl {

	@Autowired
	ProjectService service;
	
	
	@PostMapping(path="/check")
	public String addBusType(@RequestBody BusType newBus) {
		// TODO Auto-generated method stub	
		try {
			service.addBusType(newBus);
			return "Bus Added Successfully";
		} catch (BusServiceException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}

	@PutMapping(path="/updateStatus")
	public String updateBusStatus(@RequestBody UpdateDto updto) {
		// TODO Auto-generated method stub
		try {
			service.updateBusStatus(updto.getBusName(), updto.getBusStatus());
			return "update success";
		} catch (BusServiceException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}

	@DeleteMapping(path="/deleteBus")
	public String deleteBus(@RequestBody DeleteBusDto deletedto) {
		// TODO Auto-generated method stub
		try {
			service.deleteBus(deletedto.getBusName());
			return "Bus deleted succesfully";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}

	@GetMapping(path="/getbustype")
	public BusType getBusType(@RequestBody GetBusTypeDto busTypeDto) {
		return service.getBusType(busTypeDto.getBusName()); 
	}

	@PostMapping(path="/addBusDetails")
	public String addBusDetails(@RequestBody BusDetails details) {
		try {
			service.addBusDetails(details);
			return "Bus added Successfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@DeleteMapping(path="/deletebusdetails")
	public String deleteBusDetails(@RequestBody DeleteBusDetailsDto deleteBusDetailsDto) {
		try {
			service.deleteBusDetails(deleteBusDetailsDto.getRouteNo());
			return "Bus deleted Successfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}


	@PutMapping(path="/updatebusdetails")
	public String updateBusDetails(@RequestBody BusDetailsDto busDetailsDto) 
	{
		try {
			service.updateBusDetails(busDetailsDto.getRouteNo(), busDetailsDto.getBusName());
			return "Bus updated successfully";
		} catch (BusServiceException e) {
			return e.getMessage();
		}
	}	

	
	public BusDetails getBus(int routeNo) {
		// TODO Auto-generated method stub
		return service.getBus(routeNo);
	}

	public void addRoute(BusRoute newRoute) {
		// TODO Auto-generated method stub
		service.addRoute(newRoute);
	}

	public void deleteRoute(int pathNo) {
		// TODO Auto-generated method stub
		service.deleteRoute(pathNo);
	}
	
    @PostMapping(path="/searchbus")
	public List<BusOutput> searchBus(@RequestBody SearchDto searchDto) {
		List<String[]> list =  service.searchBus(searchDto.getSrc(), searchDto.getDest(), searchDto.getFromTime(), searchDto.getToTime(), searchDto.getTypeOfUser());
		List<BusOutput> dtoObjfinal = new ArrayList<BusOutput>();
		for(String[] obj:list) {
			BusOutput dtoObj = new BusOutput();
			dtoObj.setPathNo(obj[0]);
			dtoObj.setSource(obj[1]);
			dtoObj.setDestination(obj[2]);
			dtoObj.setRouteNo(obj[3]);
			dtoObj.setDistance(obj[4]);
			dtoObj.setStartTime(obj[5]);
			dtoObj.setReachTime(obj[6]);
			dtoObj.setFare(obj[7]);
			dtoObj.setBusNo(obj[8]);
			dtoObj.setBusName(obj[9]);
			dtoObj.setBusType(obj[10]);
			dtoObj.setBusStatus(obj[11]);
			dtoObjfinal.add(dtoObj);
		}
		return dtoObjfinal;
    }

	public BusRoute getRouteDetails(int pathNo) {
		// TODO Auto-generated method stub
		return service.getRouteDetails(pathNo);
	}

	public void addUnAuthorizedUser(Reservation res, String Email, String PhoneNo) {
		// TODO Auto-generated method stub
		service.addUnAuthorizedUser(res, Email, PhoneNo);
	}
	
	@PostMapping(path="/addregistration")
	public Status addRegistration(@RequestBody Registration newRegister) {
		try {
			service.addRegistration(newRegister);
			Status status = new Status();
			status.setMessage("Registeration done");
			status.setStatus(StatusType.SUCCESS);
			return status;
		} 
		catch (BusServiceException e) {
			Status status = new Status();
			status.setMessage(e.getMessage());
			status.setStatus(StatusType.FAILURE);
			return status;
		}
	}

	public void updateBookedTicket(String email, int noOfTicket) {
		// TODO Auto-generated method stub
		service.updateBookedTicket(email, noOfTicket);
	}

	public double getWallet(String email) {
		// TODO Auto-generated method stub
		return service.getWallet(email);
	}

	public void updateWallet(String email, double amount) {
		// TODO Auto-generated method stub
		service.updateWallet(email, amount);
	}

	public void updateUserDetails(String email, Date dob, String gender) {
		// TODO Auto-generated method stub
		service.updateUserDetails(email, dob, gender);
	}

	@PostMapping(path="/updatepassword")
	public Status updatePassword(@RequestBody UpdatePassword updatePassword) {
		// TODO Auto-generated method stub
		try { 
		service.updatePassword(updatePassword.getEmail(), updatePassword.getOldPassword(), updatePassword.getNewPassword());
		Status status = new Status();
		status.setMessage("Password updated successfully");
		status.setStatus(StatusType.SUCCESS);
		return status;
		}
		catch (BusServiceException e) {
			Status status = new Status();
			status.setMessage("You entered wrong old password");
			status.setStatus(StatusType.FAILURE);
			return status;
		}
	}

	@PostMapping(path="/forgotpass")
	public Status forgotPass(@RequestBody ForgotPassDto forgotPass) {
		try {
			String tx= "Hello, Your reset password link has been sent to your email";
			String fromEmail = "keshavmishra288@gmail.com"; //requires valid gmail id
			String password = "Keshav@123"; // correct password for gmail id
			String toEmail =forgotPass.getEmail();

			String host = "smtp.gmail.com";
			System.out.println("Email Start");
			//tx = "from \n"+fromEmail+"\n\n"+tx;
			Properties props = new Properties();

			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			Session session = Session.getDefaultInstance(props,
			        new javax.mail.Authenticator() {
			            protected PasswordAuthentication getPasswordAuthentication() {
			                return new PasswordAuthentication(fromEmail, password);
			            }
			        });


			try {
			    MimeMessage message = new MimeMessage(session);
			    message.setFrom(new InternetAddress(fromEmail));
			    message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			    message.setSubject("Message from Keshav");
			    message.setText(tx);

			    //send the message
			    try {
			        Transport.send(message);
			        System.out.println("message sent successfully...");
			    } catch (MailConnectException e) {
			        System.out.println("NETWORK ERROR");
			        System.out.println("PLEASE CHECK YOUR INTERNET CONNECTION");
			    }


			} catch (MessagingException e) {
			    e.printStackTrace();
			}
			Status status = new Status();
			status.setMessage("Password reset link has been sent to your email");
			status.setStatus(StatusType.SUCCESS);
			return status;
		} catch (BusServiceException e) {
			// TODO Auto-generated catch block
			Status status = new Status();
			status.setMessage("Wrong email address, Re-Enter email!!");
			status.setStatus(StatusType.FAILURE);
			return status;
		}
	}
	public List<Registration> noBookedTicket() {
		// TODO Auto-generated method stub
		return service.noBookedTicket();
	}


	@PostMapping(path="/login")
	public Status login(@RequestBody LoginDto loginDto) {
		
		try {
			service.login(loginDto.getEmailId(), loginDto.getPassword());
			Status status = new Status();
			status.setMessage("User Login Successfully");
			status.setStatus(StatusType.SUCCESS);
			return status;
		} catch (BusServiceException e) {
			Status status = new Status();
			status.setMessage(e.getMessage());
			status.setStatus(StatusType.FAILURE);
			return status;
		}
	}

	@PostMapping(path="/walletbalance")
	public double walletBalance(@RequestBody WalletBalance walletBalance) {
		// TODO Auto-generated method stub
		return service.walletBalance(walletBalance.getEmail());
	}

	public void addUserTicket(Registration reg, Reservation res) {
		// TODO Auto-generated method stub
		service.addUserTicket(reg, res);
	}

	@PostMapping(path="/allbookedticket")
	public List<String[]> allBookedTicket(@RequestBody AllBookedTicket allBookedTicket){
		// TODO Auto-generated method stub
		return service.allBookedTicket(allBookedTicket.getEmailId());
	}

	@PostMapping(path="/addreservation")
	public String addReservation(@RequestBody ResDto obj) throws ParseException {

		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date sqlDate = null;
			java.sql.Date sqlDate1 = null;
			String date = obj.getDoj();
			if( !date.isEmpty()) {
			     java.util.Date normalDate = sdf1.parse(date);
				 sqlDate = new java.sql.Date(normalDate.getTime());
			 }
			
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
			
			BusRoute routeObj = service.getRouteDetails(Integer.valueOf(obj.getPathNo()));
			Reservation resObj = new Reservation();
			resObj.setDateOfJourney(sqlDate);
			resObj.setBookingDate(sqlDate1);
			resObj.setSeatNo(Integer.valueOf(obj.getSeatNo()));
			resObj.setNewRoute(routeObj);
			resObj.setTicketStatus("booked");
			System.out.println("Res : " + resObj.hashCode());
			System.out.println("Route : " + routeObj.hashCode());
			service.addReservation(resObj);
			
			try {
				Registration regObj = service.userRegistrationDetails(obj.getEmail());
				service.addUserTicket(regObj, resObj);
			}catch(Exception e) {
				service.addUnAuthorizedUser(resObj, obj.getEmail(), obj.getPhone());
			}
			
			
			return "Successful";
		} catch (Exception e) {
			return "UnSuccessful " + e.getMessage();
		}
	}

	public void update(int ticketNo, String status, Date cancelDate, double refundAmt) {
		// TODO Auto-generated method stub
		service.update(ticketNo, status, cancelDate, refundAmt);
	}

	public String[] frequentTravelRoute() {
		// TODO Auto-generated method stub
		return service.frequentTravelRoute();
	}

	public double lastMonthProfit() {
		// TODO Auto-generated method stub
		return service.lastMonthProfit();
	}

	public int mostPreferredBus() {
		// TODO Auto-generated method stub
		return service.mostPreferredBus();
	}

	public List<Reservation> dailyBooked(Date date) {
		// TODO Auto-generated method stub
		return service.dailyBooked(date);
	}

	public List<Reservation> weeklyBooked(Date date1, Date date2) {
		// TODO Auto-generated method stub
		return service.weeklyBooked(date1, date2);
	}

	@PostMapping(path="/availableseats")
	public SeatsFindDto availableSeats(@RequestBody AvailableSeatsDto seatsDto){
		// TODO Auto-generated method stub
		
		List<Integer> list = service.availableSeats(seatsDto.getBusNo(),seatsDto.getDoj(),seatsDto.getSrc(),seatsDto.getDest());
		SeatsFindDto seats = new SeatsFindDto();
		seats.setSeat(list);
		return seats;
	}
	
	
	@PostMapping(path="/searchticket")
	public SearchBookedTicket searchTicket(@RequestBody SearchTicketdto searchTicketDto) {
		// TODO Auto-generated method stub
		
		String[] str = service.searchTicket(searchTicketDto.getTicketNo());
		SearchBookedTicket obj1 = new SearchBookedTicket();
		obj1.setBookingDate(str[0]);
		obj1.setDateOfJourney(str[1]);
		obj1.setTicketNo(str[2]);
		obj1.setSeatNo(str[3]);
		obj1.setBusNo(str[4]);
		obj1.setSource(str[5]);
		obj1.setDestination(str[6]);
		obj1.setFare(str[7]);
		obj1.setStartTime(str[8]);
		obj1.setReachTime(str[9]);
		
		return obj1;	
	}

	@PostMapping(path="/cancelticket")
	public Status cancelTicket(@RequestBody CancelTicketDto cancelTicket) {
		// TODO Auto-generated method stub
		try {
		service.cancelTicket(cancelTicket.getTicketNo(), cancelTicket.getEmail());
		Status status = new Status();
		status.setMessage("Ticket Cancel Succesfully");
		status.setStatus(StatusType.SUCCESS);
		return status;
		}
		catch (BusServiceException e) {
			Status status = new Status();
			status.setMessage(e.getMessage());
			status.setStatus(StatusType.FAILURE);
			return status;
		}
	}

	public Reservation getReservation(int ticketNo) {
		// TODO Auto-generated method stub
		return service.getReservation(ticketNo);
	}

	public void printTicket() {
		// TODO Auto-generated method stub
	}

	@PostMapping(path="/userdetails")
	public Registration userRegistrationDetails(@RequestBody UserDetails userDetails) {

		return service.userRegistrationDetails(userDetails.getEmail());

	}
	
}

