package com.ebook.model.partner;
import java.util.List;
import java.util.Set;

import com.ebook.dal.PartnerDAO;
import com.ebook.dal.ProductDAO;
import com.ebook.model.item.Product;
import com.ebook.model.item.ProductManager;
import com.ebook.service.item.representation.ProductRequest;

public class PartnerManager {
	
   public PartnerManager(){}
    
   private static PartnerDAO partners = new PartnerDAO();
   public ProductManager market = new ProductManager();
   
   
   public Partner addPartner(String name, String partnerInfo) {
	  Partner partnerNew = partners.addPartner(name,partnerInfo);
	  return partnerNew;
   }
   
   
   public static Partner findPartnerById(String id) {
	 return partners.findPartnerById(id);
   }
    
   
   public void removePartner(String id) {
	   partners.removePartner(id);	  
   }

   
   public Set<Partner>getAllPartners(){
	   Set<Partner> list_partners = partners.getAllPartners();
	   
	   return list_partners;
   }
   
   public List<PartnerInventory>getPartnerInventory(String id){
	  return partners.partnerInventory(id);   
   }
   
   public Product addPartnerProduct(String partnerId,String title,String description,double price, String author, int quantity) {
		
		ProductRequest productRequest = new ProductRequest();
		productRequest.setTitle(title);
		productRequest.setDescription(description);
		productRequest.setPrice(price);
		productRequest.setAuthor(author);
			
			// add product to marketplace
		Product product = ProductDAO.AddPartnerProduct(productRequest); 
		String id = product.getproductId();
			
			// add product to partner inventory
		partners.addProduct(partnerId, product, quantity);
		return product;
	 }
   
   
   public String deleteProduct(String partnerId, String productId) {
	  try {  
		 market.removeProduct(productId);
		 return partners.deleteProduct(partnerId, productId);	 
	  }catch(Exception ex) {
		  System.out.print("Couldn't find product on a marketplace");
	  }
	   
	  return null;
   	}
}
