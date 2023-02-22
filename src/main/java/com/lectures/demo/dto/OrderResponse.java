package com.lectures.demo.dto;

public class OrderResponse {
    private String orderTackingNumber;
    private String status;
    private String message;
	public String getOrderTackingNumber() {
		return orderTackingNumber;
	}
	public void setOrderTackingNumber(String orderTackingNumber) {
		this.orderTackingNumber = orderTackingNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public OrderResponse(String orderTackingNumber, String status, String message) {
		super();
		this.orderTackingNumber = orderTackingNumber;
		this.status = status;
		this.message = message;
	}
	public OrderResponse() {
		super();
	}
	@Override
	public String toString() {
		return "OrderResponse [orderTackingNumber=" + orderTackingNumber + ", status=" + status + ", message=" + message
				+ "]";
	}
    
}
