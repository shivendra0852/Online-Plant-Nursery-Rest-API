package com.greenhood.exception;

public class AdminCurrentSessionException extends RuntimeException{

	public AdminCurrentSessionException() {
		super();
		
	}

	public AdminCurrentSessionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public AdminCurrentSessionException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AdminCurrentSessionException(String message) {
		super(message);
		
	}

	public AdminCurrentSessionException(Throwable cause) {
		super(cause);
		
	}

}
