package com.gowthamrajk.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class StatusNotFoundException extends Exception {
	
	public StatusNotFoundException(String message) {
		
		super(message);
	}

}
