package com.ebook.model.partner;
import java.util.Set;

import com.ebook.dal.PartnerDAO;

public class PartnerManager {
    public PartnerManager(){}
    
   private static PartnerDAO partners = new PartnerDAO();
   
   
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
}
