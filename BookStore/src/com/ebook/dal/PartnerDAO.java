package com.ebook.dal;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import com.ebook.model.item.Product;
import com.ebook.model.partner.Partner;
import com.ebook.model.partner.PartnerInventory;

public class PartnerDAO {
	
	private static HashMap<String,Partner>partners = new HashMap<>();
	
    public PartnerDAO(){
    	
    	Product pr = new Product();
    	pr.setTitle("The Hobbit");
    	pr.setDescription("Children's fantasy novel");
    	pr.setAuthor("J. R. R. Tolkien");
    	pr.setPrice(10.10);
    	pr.setproductId("PI58");
    	Partner partner1 = new Partner("PI123","Shiny Owl Books","Welcome to Shiny Owl Books, a general bookshop with several room with 15,000 books in the shop. We sell a wide variety of Fiction,"
    	   		+ " Factual and Childrens Books including many thousands"
    	   		+ " of paperback novels, childrens books and popular non-fiction titles");
    	partner1.addPartnerProduct(pr,10);    	
    	partners.put("PI123",partner1);  
    	    	
    	Product pr2 = new Product();
    	pr2.setTitle("A Game of Thrones");
    	pr2.setDescription("Fantasy novel");
    	pr2.setAuthor("George R. R. Martin");
    	pr2.setPrice(20.10);
    	pr2.setproductId("PI51");
    	
    	Product pr3 = new Product();
    	pr3.setTitle("Shantaram");
    	pr3.setDescription("Novel");
    	pr3.setAuthor("Gregory David Roberts");
    	pr3.setPrice(30.50);
    	pr3.setproductId("PI42");
    	
    	PartnerInventory pri1 = new PartnerInventory(pr3,10);
    	
    	Partner partner2 = new Partner("PI147","Amazon Books","Amazon Books is a customer-focused store, "
    			+ "designed to spur discovery; a place where customers can find great books and products"
    	   		+ " of paperback novels, childrens books and popular non-fiction titles");
    	   
    	partner2.addPartnerProduct(pr2,10);   
    	partners.put("PI147",partner2);  
    }
   
   public Partner addPartner(String name, String partnerInfo) {
	  Random randomGenerator = new Random();
	  int randomInt = randomGenerator.nextInt(10000);
	  String id = "PI" + randomInt; 
	   
	  Partner partner = new Partner(id, name, partnerInfo);
	  partners.put(id,partner);
	  return partner;
   }
   
   
   
   public Partner findPartnerById(String id) {
	 return partners.get(id);
   }
    
   public void removePartner(String id) {
	   partners.remove(id);
	  
   }
   
   public Set<Partner>getAllPartners(){
	   Set<Partner> set_partners = new HashSet<>();
	   
	   for (Map.Entry<String,Partner> i : partners.entrySet()) {
		   set_partners.add(i.getValue());
	   }      
	   return set_partners;
   }
   
   public List<PartnerInventory> partnerInventory(String id) {
		Partner pr = findPartnerById(id);		
		return pr.getInventory();		
	} 
   
   public void addProduct(String productId,String partnerid,Product product, int quantity) {
	   Partner partner = findPartnerById(partnerid);
	   partner.addPartnerProduct(product,quantity);	  

   }
   
   public String deleteProduct(String productId) {
	   String prID = findPartnerbyProduct(productId);
	   Partner partner = findPartnerById(prID);
	   
	   List<PartnerInventory> inventory = partner.getInventory();
	   
	  
		   for (PartnerInventory i: inventory) {
			   if (i.getProduct().getproductId().equals(productId)) {
				   inventory.remove(i);
				   return "OK";
			   }else {
				   continue;
				  
			   }
		   }
	System.out.println("Couldn't find the product in database");
	return null;
   }
   
   public String findPartnerbyProduct(String productID) {
	   for (Entry <String, Partner> p:partners.entrySet()) {
		   
		   Partner partner = p.getValue();
		   for (PartnerInventory pi : partner.getInventory()) {
			   if (pi.getProduct().getproductId().equals(productID)) {
				   	return partner.getpartnerId();
				   }		   
			   }
	   } 
	   return "Could't find a partner with this product ID";
	   //return null; 
	}
}
    