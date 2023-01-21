package com.greenhood.exception;

public class CartException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CartException() {
		
	}
	
	public CartException(String message) {
		super(message);
	}
}
