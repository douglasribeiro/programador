package com.example.programador.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item  implements Serializable{

	private static final long serialVersionUID = -2598265051604140739L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemID;
	
	@Column(length = 30)
	private String name;
	
	@Column(scale=2,precision=18)
	private double price;

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
