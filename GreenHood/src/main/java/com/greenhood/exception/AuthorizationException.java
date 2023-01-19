package com.greenhood.exception;

@SuppressWarnings("serial")
public class AuthorizationException extends RuntimeException{
	
	public AuthorizationException() {
		
	}
	
	public AuthorizationException(String message) {
		super(message);
	}

}
