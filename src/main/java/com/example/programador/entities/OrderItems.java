package com.example.programador.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderItems implements Serializable{

	private static final long serialVersionUID = -1289696216198828515L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderItems;
	
	@OneToOne
	private Order orderID;
	
	@OneToOne
	private Item itemID;
	
	private int quantity;

	public Long getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Long orderItems) {
		this.orderItems = orderItems;
	}

	public Order getOrderID() {
		return orderID;
	}

	public void setOrderID(Order orderID) {
		this.orderID = orderID;
	}

	public Item getItemID() {
		return itemID;
	}

	public void setItemID(Item itemID) {
		this.itemID = itemID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
}
