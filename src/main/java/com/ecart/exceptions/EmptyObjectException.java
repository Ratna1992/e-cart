package com.ecart.exceptions;

@SuppressWarnings("serial")
public class EmptyObjectException extends RuntimeException {

	public EmptyObjectException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public EmptyObjectException(String message) {
		super(message);
		
	}

	public EmptyObjectException(Throwable cause) {
		super(cause);
	}

	
}
