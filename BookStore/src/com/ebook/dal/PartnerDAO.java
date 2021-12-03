package com.ebook.dal;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.ebook.model.item.Book;
import com.ebook.model.item.Product;
import com.ebook.model.partner.Partner;
import com.ebook.*;

public class PartnerDAO {
	
	private static HashMap<String,Partner>partners = new HashMap<>();
	
    public PartnerDAO(){
    	Partner partner1 = new Partner("PI123","Shiny Owl Books","Welcome to Shiny Owl Books, a general bookshop with several room with 15,000 books in the shop. We sell a wide variety of Fiction,"
    	   		+ " Factual and Childrens Books including many thousands"
    	   		+ " of paperback novels, childrens books and popular non-fiction titles");
    	   
    	
    	partners.put("PI123",partner1);  
    	
    	Partner partner2 = new Partner("PI147","Amazon Books","Amazon Books is a customer-focused store, "
    			+ "designed to spur discovery; a place where customers can find great books and products"
    	   		+ " of paperback novels, childrens books and popular non-fiction titles");
    	   
    	
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
}
    