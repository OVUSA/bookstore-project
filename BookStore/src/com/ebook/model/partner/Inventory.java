
package com.ebook.model.partner;


import java.util.List;

import com.ebook.model.item.Product;

public interface Inventory {
	public void addPartnerProduct(PartnerInventory product, String productId);
	
	public void deletePartnerProduct(String id);
	public void incresePartnerProductQuantity(String productId, int amount);
	public void decreasePartnerProductQuantity(String productId, int amount);
	public List<PartnerInventory> reviewAllPartnerProducts();
	
}
