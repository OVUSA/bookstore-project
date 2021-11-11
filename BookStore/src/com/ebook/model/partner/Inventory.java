
package com.ebook.model.partner;


import java.util.List;


public interface Inventory {
	public PartnerInventory addPartnerProduct(String title,String description,double price, String author, int quantity);
	public void deletePartnerProduct(String id);
	public void incresePartnerProductQuantity(String productId, int amount);
	public void decreasePartnerProductQuantity(String productId, int amount);
	public List<PartnerInventory> reviewAllPartnerProducts();
	
}
