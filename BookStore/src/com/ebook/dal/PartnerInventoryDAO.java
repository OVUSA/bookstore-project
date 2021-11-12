package com.ebook.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ebook.model.item.Product;
import com.ebook.model.partner.Inventory;
import com.ebook.model.partner.PartnerInventory;

public class PartnerInventoryDAO {
	
	public PartnerInventoryDAO() {
		
	}
   
    Map <String,PartnerInventory> partnerInventory = new HashMap<>();
    
	public void addPartnerProduct(PartnerInventory product, String productId) {
		partnerInventory.put(productId,product);
		
	}

	public String deletePartnerProduct(String id) {
		 PartnerInventory pr = partnerInventory.remove(id);
		 return pr.getProduct().getTitle();
	}

	
	public void incresePartnerProductQuantity(String productId, int amount) {
		 PartnerInventory pr = partnerInventory.get(productId);
		 int quantity = pr.getQuantity();
		 pr.setQuantity(quantity+amount);
	
	}

	public void decreaseQuantity(String productId, int amount) {
		PartnerInventory pr = partnerInventory.get(productId);
		 int quantity = pr.getQuantity();
		 pr.setQuantity(quantity-amount);
		
	}
	
	public List<PartnerInventory> reviewAllProducts() {
		List<PartnerInventory>partnerInv = new ArrayList<>();

		for (Map.Entry<String,PartnerInventory> partProdu:partnerInventory.entrySet()) {
			partnerInv.add(partProdu.getValue());
		}
		return partnerInv;
	}
}

