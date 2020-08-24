package com.lti.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BusDetails")
public class BusDetails {

	@Id
	@Column(length=20)
	private int routeNo;
	
	@ManyToOne 
	@JoinColumn(name="new_bus_name")
	private BusType newBusName;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL) 
	private Set<BusRoute> newRoute;
	
	public BusDetails() {
		super();
	}

	public int getRouteNo() {
		return routeNo;
	}

	public void setRouteNo(int routeNo) {
		this.routeNo = routeNo;
	}

	public BusType getNewBusName() {
		return newBusName;
	}

	public void setNewBusName(BusType newBusName) {
		this.newBusName = newBusName;
	}

	public Set<BusRoute> getNewRoute() {
		return newRoute;
	}

	public void setNewRoute(Set<BusRoute> newRoute) {
		this.newRoute = newRoute;
	}
	
	
	
}
