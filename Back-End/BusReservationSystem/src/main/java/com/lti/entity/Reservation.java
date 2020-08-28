package com.lti.entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Reservation")
public class Reservation {

	@Id
	@Column(length=5)
	@GeneratedValue
	private int ticketNo;
	@Temporal(TemporalType.DATE)
	private Date bookingDate;
	@Temporal(TemporalType.DATE)
	private Date dateOfJourney;
	@Column(length=10)
	private int seatNo;
	@Column(length=10)
	private String ticketStatus;
	@Temporal(TemporalType.DATE)
	private Date cancellationDate;
	@Column(length=10)
	private double refundAmount;
	
	@ManyToOne 
	@JoinColumn(name="new_pathNo")
	private BusRoute newRoute;
	
	@OneToOne(mappedBy = "newReservation")  
	private UnAuthorized newUnAuthorized;
	
	
	@OneToOne(mappedBy = "newRegTic")  
	private RegisteredUserTicket regTicket;
	
	public Reservation() {
		super();
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public Date getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(Date cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	public double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	public BusRoute getNewRoute() {
		return newRoute;
	}

	public void setNewRoute(BusRoute newRoute) {
		this.newRoute = newRoute;
	}

	public UnAuthorized getNewUnAuthorized() {
		return newUnAuthorized;
	}

	public void setNewUnAuthorized(UnAuthorized newUnAuthorized) {
		this.newUnAuthorized = newUnAuthorized;
	}

	public RegisteredUserTicket getRegTicket() {
		return regTicket;
	}

	public void setRegTicket(RegisteredUserTicket regTicket) {
		this.regTicket = regTicket;
	}

	
		
}
