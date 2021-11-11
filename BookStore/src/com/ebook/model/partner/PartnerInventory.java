package com.ebook.model.partner;

import com.ebook.dal.PartnerInventoryDAO;
import com.ebook.model.item.Product;

public class PartnerInventory {
	private Product product;
	private int quantity;
	private PartnerInventoryDAO inventoryDAO;
	
	PartnerInventory(Product product, int quantity){
		this.product = product;
		this.quantity = quantity;
	}
	
	PartnerInventory(){
		this.inventoryDAO = new PartnerInventoryDAO();
		
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

	public PartnerInventoryDAO getInventoryDAO() {
		return inventoryDAO;
	}

	public void setInventoryDAO(PartnerInventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}

}
