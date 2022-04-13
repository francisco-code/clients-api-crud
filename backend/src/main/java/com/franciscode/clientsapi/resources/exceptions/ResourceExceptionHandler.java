package com.franciscode.clientsapi.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.franciscode.clientsapi.services.exceptions.DataBaseException;
import com.franciscode.clientsapi.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setError("Resource not found");
		error.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> database(DataBaseException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setError("Database exception");
		error.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}

}
