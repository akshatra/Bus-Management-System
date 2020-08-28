package com.lti.exception;

public class BusServiceException extends RuntimeException{
	
	public BusServiceException() {
		super();
	}
	public BusServiceException(String msg) {
		super(msg);
	}
}
