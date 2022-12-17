package com.ecart.exceptions;

@SuppressWarnings("serial")
public class OrderFieldViolationException extends RuntimeException {

	public OrderFieldViolationException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public OrderFieldViolationException(String message) {
		super(message);
		
	}

	public OrderFieldViolationException(Throwable cause) {
		super(cause);
	}

}
