package com.ecart.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ecart_orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	@NotNull
	@Max(value=16) 
	private Integer orderId;
	
    @NotNull
	@Column(name="order_description")
	private String orderDescription;
	
    @NotNull
	@Column(name="order_qty")
	private Integer orderQuantity;
	
    @NotNull
	@Column(name="order_price")
	private BigDecimal orderPrice;
	
    @NotNull
	@Column(name="order_creation_time") 
	private Date orderCreationTime;
	
    
	@Column(name="order_updation_time")
	private Date orderUpdationTime;
	
    @NotNull
	@Column(name="order_delivered")
	private Boolean orderDelivered;
	
	
	public Order() {
		
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Date getOrderCreationTime() {
		return orderCreationTime;
	}

	public void setOrderCreationTime(Date orderCreationTime) {
		this.orderCreationTime = orderCreationTime;
	}

	public Date getOrderUpdationTime() {
		return orderUpdationTime;
	}

	public void setOrderUpdationTime(Date orderUpdationTime) {
		this.orderUpdationTime = orderUpdationTime;
	}

	public Boolean getOrderDelivered() {
		return orderDelivered;
	}

	public void setOrderDelivered(Boolean orderDelivered) {
		this.orderDelivered = orderDelivered;
	}

	public Order(String orderDescription, Integer orderQuantity, BigDecimal orderPrice,
			Date orderCreationTime, Date orderUpdationTime, Boolean orderDelivered) {
		super();
		
		this.orderDescription = orderDescription;
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
		this.orderCreationTime = orderCreationTime;
		this.orderUpdationTime = orderUpdationTime;
		this.orderDelivered = orderDelivered;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDescription=" + orderDescription + ", orderQuantity="
				+ orderQuantity + ", orderPrice=" + orderPrice + ", orderCreationTime=" + orderCreationTime
				+ ", orderUpdationTime=" + orderUpdationTime + ", orderDelivered=" + orderDelivered + "]";
	}
	
}
