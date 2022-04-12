package com.franciscode.clientsapi.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -3862026733169547576L;
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}
