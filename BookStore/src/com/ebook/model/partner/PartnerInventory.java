package com.ebook.model.partner;

import com.ebook.model.item.Product;

public class PartnerInventory {
	private String id;
	private Product product;
	private int quantity;
	
	
	public PartnerInventory(Product product, int quantity){
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}
