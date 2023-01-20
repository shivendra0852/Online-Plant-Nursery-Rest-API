package com.greenhood.exception;

public class PlanterException extends RuntimeException {

	public PlanterException() {
		super();
		
	}

	public PlanterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public PlanterException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PlanterException(String message) {
		super(message);
		
	}

	public PlanterException(Throwable cause) {
		super(cause);
		
	}

}
