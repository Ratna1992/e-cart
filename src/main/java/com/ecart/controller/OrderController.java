package com.ecart.controller;

import java.util.NoSuchElementException;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.entity.Order;
import com.ecart.exceptions.EmptyObjectException;
import com.ecart.exceptions.OrderFieldViolationException;
import com.ecart.exceptions.OrderNotFoundException;
import com.ecart.service.OrderService;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping
	public ResponseEntity<?> createOrder(@RequestBody Order orderObj) {
		Order order=null;
		try {
			if(orderObj.getOrderDelivered()==null||orderObj.getOrderDescription()==null||orderObj.getOrderPrice()==null||orderObj.getOrderQuantity()==null) {
				throw new EmptyObjectException("Request object cannot be null");
			}
			 order=orderService.createOrder(orderObj);
		}
		catch(Exception e){
		    if(e instanceof TransactionSystemException) {
				throw new OrderFieldViolationException(e.getMessage());
			}
		    else if(e instanceof EmptyObjectException) {
		    	throw new EmptyObjectException(e.getMessage());
		    }
		}
		return new ResponseEntity<>(order,HttpStatus.OK);
		
	}

	@GetMapping
	public ResponseEntity<?> getAllOrder() {

		Iterable<Order> order = null;
		try {
			order = orderService.getAllOrders();
		} catch (Exception e) {
			throw new OrderNotFoundException(e.getMessage());	
		}
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	@GetMapping(value = "/{orderId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getOrder(@PathVariable Integer orderId) {

		Order order = null;
		try {
			order = orderService.getOrder(orderId);
		} catch (Exception e) {
			throw new OrderNotFoundException(e.getMessage());	
		}
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	@PutMapping(value = "/{orderId}")
	public ResponseEntity<?> updateOrder(@PathVariable Integer orderId,@RequestBody Order orderObj ) {
		Order order=null;
	try {
			 order=orderService.updateOrder(orderId,orderObj);
		}
		catch(Exception e) {
			if(e instanceof NoSuchElementException) {
				throw new OrderNotFoundException(e.getMessage());
			}else if(e instanceof TransactionSystemException) {
				throw new OrderFieldViolationException(e.getMessage());
			}
				
		}
		
		return new ResponseEntity<>(order,HttpStatus.OK);
	}

	@DeleteMapping(value = "/{orderId}")
	public ResponseEntity<?> deleteOrder(@PathVariable Integer orderId) {
		try {
			
			orderService.DeleteOrder(orderId);
		}
		catch(Exception e) {
			if(e instanceof EmptyResultDataAccessException) {
				throw new OrderNotFoundException(e.getMessage());
			}
		}
		return new ResponseEntity<>("orderDeleted",HttpStatus.OK);
	}
}
