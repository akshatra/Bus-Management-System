package com.lti.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Bus_Route")
public class BusRoute {
	@Id
	@GeneratedValue
	private int pathNo;
	
	@Column(length = 20)
	private int busNo;
	
	@Column(length=20)
	private String source;
	
	@Column(length=20)
	private String destination;
	
	@Column(length=20)
	private int distance;
	
	@Column(length=20)
	private String startTime;
	
	@Column(length=20)
	private String reachTime;
	
	@Column(length=20)
	private int fare;
	
	@ManyToOne 
	@JoinColumn(name="route_no")
	private BusDetails newBusDetails;
	
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL) 
	private Set<Reservation> newReservations;
	
	public BusRoute() {
		super();
	}
	
	public int getPathNo() {
		return pathNo;
	}
	public void setPathNo(int pathNo) {
		this.pathNo = pathNo;
	}
	public int getBusNo() {
		return busNo;
	}
	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getReachTime() {
		return reachTime;
	}

	public void setReachTime(String reachTime) {
		this.reachTime = reachTime;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public BusDetails getNewBusDetails() {
		return newBusDetails;
	}

	public void setNewBusDetails(BusDetails newBusDetails) {
		this.newBusDetails = newBusDetails;
	}

	public Set<Reservation> getNewReservations() {
		return newReservations;
	}

	public void setNewReservations(Set<Reservation> newReservations) {
		this.newReservations = newReservations;
	}

	
	
}