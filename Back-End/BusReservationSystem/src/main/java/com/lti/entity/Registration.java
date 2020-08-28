package com.lti.entity;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Registration")
public class Registration {
	@Id
	@Column(length=30)
	private String email;
	@Column(length=20)
	private String firstName;
	@Column(length=20)
	private String lastName;
	@Column(length=20)
	private String password;
	@Column(length=20)
	private String phone;
	@Column(length=20)
	private Date dateOfBirth;
	@Column(length=20)
	private String gender;
	@Column(length=20)
	private int noOfBookedTicket;
	@Column(length=20)
	private double wallet;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL) 
	private Set<RegisteredUserTicket> registerTicket;

	public Registration() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getNoOfBookedTicket() {
		return noOfBookedTicket;
	}

	public void setNoOfBookedTicket(int noOfBookedTicket) {
		this.noOfBookedTicket = noOfBookedTicket;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	public Set<RegisteredUserTicket> getRegisterTicket() {
		return registerTicket;
	}

	public void setRegisterTicket(Set<RegisteredUserTicket> registerTicket) {
		this.registerTicket = registerTicket;
	}
	
	
	
}
