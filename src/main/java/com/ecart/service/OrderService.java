package com.ecart.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.dao.OrderDao;
import com.ecart.entity.Order;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public Order createOrder(Order obj) {
		obj.setOrderCreationTime(new Date());
		return orderDao.save(obj);
	}

	public Iterable<Order> getAllOrders() {
		return orderDao.findAll();
	}

	public Order getOrder(Integer orderId) {
		return orderDao.findById(orderId).get();
	}

	public Order updateOrder(Integer orderId, Order orderObj) {
		Order oldobj = orderDao.findById(orderId).get();
		if (orderObj.getOrderDescription() != null) {
		oldobj.setOrderDescription(orderObj.getOrderDescription());

		}
		if(orderObj.getOrderQuantity()!=null) {
			oldobj.setOrderQuantity(orderObj.getOrderQuantity());
		}
		if(orderObj.getOrderPrice()!= null){
			oldobj.setOrderPrice(orderObj.getOrderPrice());
		}
		oldobj.setOrderUpdationTime(new Date());
		if(orderObj.getOrderDelivered()!= null){
			oldobj.setOrderDelivered(orderObj.getOrderDelivered());
		}
		return orderDao.save(oldobj);

	}

	public void DeleteOrder(Integer orderId) {
		orderDao.deleteById(orderId);
	}

}
