package com.ebook.model.partner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class PartnerManager {
    public PartnerManager(){}
    
   private static HashMap<String,Partner>partners = new HashMap<>();
   
   
   public Partner addPartner(String name, String partnerInfo) {
	   
	  Partner partner = new Partner(name, partnerInfo);
	  
	  Random randomGenerator = new Random();
	  int randomInt = randomGenerator.nextInt(10000);
	  String id = "PI" + randomInt;
	  
	  partner.setpartnerId(id);
	 
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
	   Set<Partner> partners = new HashSet<>();
	   Iterator<Partner>partner = partners.iterator();
	   while(partner.hasNext()) {
		   partners.add((Partner) partner);
	   }
	   return partners;
   }
}
