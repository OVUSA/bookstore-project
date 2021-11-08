package com.ebook.model.service.Partner.workflow;

import java.util.HashSet;

import java.util.Set;

import com.ebook.model.partner.Partner;
import com.ebook.model.partner.PartnerManager;
import com.ebook.model.service.Partner.representation.PartnerRepresentation;


public class PartnerActivity {

	private static PartnerManager partnerManager = new PartnerManager();
	
	public Set<PartnerRepresentation> getPartners() {
		
		Set<Partner> partners= new HashSet<Partner>();
		Set<PartnerRepresentation> partnersRepresentations = new HashSet<PartnerRepresentation>();
	    partners = partnerManager.getAllPartners();
		
		for (Partner partner:partners){		
			PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
			((Partner) partnersRepresentations).setName(partner.getPartnerName());
			 partnersRepresentations.add(partnerRepresentation);
         }         
		return partnersRepresentations;
     }

	
	public PartnerRepresentation getPartnerById(String id) {
		Partner partner = partnerManager.findPartnerById(id);
		
		PartnerRepresentation partRep = new PartnerRepresentation();
		partRep.setPartnerName(partner.getPartnerName());
		
		return partRep;
	}
	

	public PartnerRepresentation addPartner(String name, String partnerInfo){
		
		Partner partner = partnerManager.addPartner(name,partnerInfo);
		
		PartnerRepresentation partRep = new PartnerRepresentation();
		partRep.setPartnerName(partner.getPartnerName());
		partRep.setPartnerInfo(partner.getPartnerInfo());
		partRep.setPartnerID(partner.getpartnerId());
			
		return partRep;
	}
	
	public String deletePartner(String id) {
		partnerManager.removePartner(id);
		return "Partner is deleted";
	}
	
}
