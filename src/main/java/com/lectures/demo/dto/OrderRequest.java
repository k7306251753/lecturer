package com.lectures.demo.dto;

import com.lectures.demo.model.Order;
import com.lectures.demo.model.Payment;


public class OrderRequest {
    private Order order;
    private Payment payment;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public com.lectures.demo.model.Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public OrderRequest(Order order, Payment payment) {
		super();
		this.order = order;
		this.payment = payment;
	}
	public OrderRequest() {
		super();
	}
	@Override
	public String toString() {
		return "OrderRequest [order=" + order + ", payment=" + payment + "]";
	}
	
    
}
