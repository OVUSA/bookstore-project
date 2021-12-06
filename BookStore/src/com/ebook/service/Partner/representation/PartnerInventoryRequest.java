package com.ebook.service.Partner.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

public class  PartnerInventoryRequest {
	
	private String title;
	private double price;
	private String description;
	private String author;
	private int quantity;
	
	PartnerInventoryRequest(){
		
	}
	PartnerInventoryRequest(String title, String description,String author,double price, int quantity){
		this.author = author;
		this.title = title;
		this.description = description;
		this.price = price;
		this.quantity= quantity;			
		}
	
	PartnerInventoryRequest(String title){
		this.title = title;
		
	}

	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}