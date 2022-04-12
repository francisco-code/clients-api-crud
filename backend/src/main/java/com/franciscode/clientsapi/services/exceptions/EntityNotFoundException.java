package com.franciscode.clientsapi.services.exceptions;

public class EntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -3862026733169547576L;
	
	public EntityNotFoundException(String msg) {
		super(msg);
	}

}
