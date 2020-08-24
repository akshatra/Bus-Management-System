 package com.lti.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BusType")
public class BusType {
	@Id
	@Column(length=20)
	private String busName;
	@Column(length=20)
	private String type;
	@Column(length=20)
	private String busStatus;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL) 
	private Set<BusDetails> newBusDetails;

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBusStatus() {
		return busStatus;
	}

	public void setBusStatus(String busStatus) {
		this.busStatus = busStatus;
	}

	public Set<BusDetails> getNewBusDetails() {
		return newBusDetails;
	}

	public void setNewBusDetails(Set<BusDetails> newBusDetails) {
		this.newBusDetails = newBusDetails;
	}
	
	
}
