package com.ebook.service.Partner.representation;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ebook.service.AbstractRepresentation.AbstractRepresentation;

@XmlRootElement(name = "PartnerInventory")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

public class PartnerInventoryRepresentation extends AbstractRepresentation  {
	private String productId;
	private String title;
	private double price;
	private String description;
	private String author;
	
	public PartnerInventoryRepresentation(){
		
	}
		
	public String getproductId() {
		return productId;
	}

	public void setproductId(String productId) {
		this.productId = productId;
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
		
}