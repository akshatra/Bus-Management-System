package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="UnAuthorized")
public class UnAuthorized {

	@Id
	@Column(length = 20)
	@GeneratedValue
	private int userNo;
	@Column(length = 30)
	private String email;
	@Column(length = 10)
	private String phone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Ticket_No")
	private Reservation newReservation;
	
	public UnAuthorized() {
		super();
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Reservation getNewReservation() {
		return newReservation;
	}

	public void setNewReservation(Reservation newReservation) {
		this.newReservation = newReservation;
	}

}
