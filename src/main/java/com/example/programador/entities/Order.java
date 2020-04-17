package com.example.programador.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Order implements Serializable {

	private static final long serialVersionUID = -8756101223943231222L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderID;
	
	@Column(length = 50)
	private String orderNo;
	
	private Long customerID;
	
	@Column(length = 50)
	private String pMethod;
	
	@Column(scale=2,precision=18)
	private Double gTotal;
	
	@OneToMany()
	private List<OrderItems> orderItems;
	
	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public String getpMethod() {
		return pMethod;
	}

	public void setpMethod(String pMethod) {
		this.pMethod = pMethod;
	}

	public Double getgTotal() {
		return gTotal;
	}

	public void setgTotal(Double gTotal) {
		this.gTotal = gTotal;
	}

	public List<OrderItems> getItems() {
		return orderItems;
	}

	public void setItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	
	
}
