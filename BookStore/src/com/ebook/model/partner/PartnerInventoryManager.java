package com.ebook.model.partner;

import com.ebook.dal.PartnerInventoryDAO;
import com.ebook.model.item.Product;

public class PartnerInventoryManager implements Inventory{
	private PartnerInventoryDAO inventory1= new PartnerInventoryDAO();

	@Override
	public void addProduct(Product product, int quantity) {
		try{
            inventory1.addProduct(product,quantity);
        }catch (Exception ex){
            System.out.println("Partner inventory service:Threw an error adding a "+product+".");
        }
	}

	@Override
	public void deleteProduct(Product product) {
		try {
			inventory1.deleteProduct(product);
		}catch(Exception ex) {
			System.out.println("Partner inventory service: Threw an error deleting "+ product);
		}
	}

	@Override
	public void increseQuantity(Product product, int amount) {
		try {
			inventory1.increseQuantity(product,amount);
		}catch(Exception ex) {
			System.out.println("Partner inventory service: Threw an error increasing "+ product+" quantity.");
		}
		
	}

	@Override
	public void decreaseQuantity(Product product, int amount) {
		try {
			inventory1.decreaseQuantity(product,amount);
		}catch(Exception ex) {
			System.out.println("Partner inventory service: Threw an error decreasing "+ product+" quantity.");
		}
		
	}

	@Override
	public List<Product> reviewAllProducts() {
		try {
			return inventory1.reviewAllProducts();
		}catch(Exception ex) {
			System.out.println("Partner inventory service: Threw an error reviwing all partner's products");
		}
		return null;

	}

}
