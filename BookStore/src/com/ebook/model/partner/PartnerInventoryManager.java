package com.ebook.model.partner;

import java.util.List;

import com.ebook.dal.PartnerInventoryDAO;
import com.ebook.dal.ProductDAO;
import com.ebook.model.item.Product;
import com.ebook.model.item.ProductManager;
import com.ebook.service.item.representation.ProductRequest;

public class PartnerInventoryManager implements Inventory {
	private static PartnerInventoryDAO inventory1= new PartnerInventoryDAO();
	ProductManager productManager = new ProductManager();
	

	public void addPartnerProduct(String title,String description,double price, String author, int quantity) {
			
			ProductRequest productRequest = new ProductRequest();
			productRequest.setTitle(title);
			productRequest.setDescription(description);
			productRequest.setPrice(price);
			productRequest.setAuthor(author);
			
			// add product to marketplace
			Product product = ProductDAO.AddPartnerProduct(productRequest); 
			String id = product.getproductId();
			
			// add product to partner inventory
			PartnerInventory newInventoryProduct = new PartnerInventory(product,quantity);
			inventory1.addPartnerProduct(newInventoryProduct, id); 
	   }


	public void deletePartnerProduct(String id) {
		// remove product from marketplace
		productManager.removeProduct(id);
		
		// remove product from partner inventory
		String bookTitle = inventory1.deletePartnerProduct(id);
		System.out.println(bookTitle+" is deleted");
	}
	
	public void incresePartnerProductQuantity(String productID, int amount) {
		
		try {
			inventory1.incresePartnerProductQuantity(productID,amount);	 
		}catch(Exception ex) {
			System.out.println("Partner inventory service: Couldn't increasing "+" quantity of "+ productID);
		}
		
	}


	public void decreasePartnerProductQuantity(String productId, int amount){
		try {
			inventory1.decreaseQuantity(productId,amount);
		}catch(Exception ex) {
			System.out.println("Partner inventory service:Couldn't decrease "+" quantity of "+ productId);
		}	
	}

	@Override
	public List<PartnerInventory> reviewAllPartnerProducts() {
		try {
			return inventory1.reviewAllProducts();
		}catch(Exception ex) {
			System.out.println("Partner inventory service: Cant reviwing all partner' products");
		}
		return null;

	}


	

	
	   
	   
	   
	 
}
