package com.lti.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Registered_User")
public class RegisteredUserTicket {

	@Id
	@GeneratedValue
	private int userNo;
	
	
	@ManyToOne 
	@JoinColumn(name="EmailID")
	private Registration register;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Ticket_No")
	private Reservation newRegTic;
	
	public RegisteredUserTicket() {
		super();
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public Registration getRegister() {
		return register;
	}

	public void setRegister(Registration register) {
		this.register = register;
	}

	public Reservation getNewRegTic() {
		return newRegTic;
	}

	public void setNewRegTic(Reservation newRegTic) {
		this.newRegTic = newRegTic;
	}

	
	
}

