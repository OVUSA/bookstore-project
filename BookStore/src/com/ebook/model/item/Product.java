package com.ebook.model.item;

import java.io.Serializable;
//import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private String productId;
	private String title;
	private double price;
	private String description;
	private String author;
	
	public Product() {}
	
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
