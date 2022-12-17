package com.ecart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class OrderExceptionController extends ResponseEntityExceptionHandler {
	public ErrorResponse getErrorResponse(String message, String status) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(message);
		error.setStatus(status);
		return error;
	}

	@ExceptionHandler(value = OrderNotFoundException.class)
	public ResponseEntity<Object> exception(OrderNotFoundException exception) {
		ErrorResponse errorResponse = getErrorResponse(exception.getMessage(), "315.00");
		System.out.println(errorResponse);
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<Object> exception(OrderFieldViolationException exception){
		ErrorResponse errorResponse = getErrorResponse(exception.getMessage(), "55555.00");
		System.out.println(errorResponse);
		return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<Object> exception(EmptyObjectException exception){
		ErrorResponse errorResponse=getErrorResponse(exception.getMessage(),"77777");
		System.out.println(errorResponse);
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	/*
	 * @ExceptionHandler(value=NoSuchElementException.class) public
	 * ResponseEntity<Object> exception(NoSuchElementException exception){
	 * 
	 * return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT); }
	 */

}
