package com.nt.dto;

import java.io.Serializable;

import org.springframework.stereotype.Service;


public class ProductDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String iteams;
	private Double price;
	private Integer qty;
	
	
	public ProductDTO(int id, String iteams, Double price, Integer integer) {
		super();
		this.id = id;
		this.iteams = iteams;
		this.price = price;
		this.qty = integer;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public String getIteams() {
		return iteams;
	}
	@Override
	public String toString() {
		return "EcartDto [id=" + id + ", iteams=" + iteams + ", price=" + price + ", qty=" + qty + "]";
	}
	
	
	
	
}
