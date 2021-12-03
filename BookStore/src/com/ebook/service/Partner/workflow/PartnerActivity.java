package com.ebook.service.Partner.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.ebook.model.link.Link;
import com.ebook.model.partner.Partner;
import com.ebook.model.partner.PartnerManager;

import com.ebook.service.Partner.representation.PartnerRepresentation;


public class PartnerActivity {

	private static PartnerManager partnerManager = new PartnerManager();
	
	public Set<PartnerRepresentation> getPartners() {
		
		Set<Partner> partners= partnerManager.getAllPartners();
		Set<PartnerRepresentation> partnersRepresentations = new HashSet<PartnerRepresentation>();
		
		Iterator<Partner>it = partners.iterator();
		while(it.hasNext()) {
			Partner part = it.next();
			PartnerRepresentation partRep = new PartnerRepresentation();
			partRep.setPartnerName(part.getPartnerName());
			partRep.setPartnerInfo(part.getPartnerInfo());
			partRep.setPartnerID(part.getpartnerId());
			
			partnersRepresentations.add(partRep);		
		}
		return partnersRepresentations;
     }

	
	public PartnerRepresentation getPartnerById(String id) {
		Partner partner = PartnerManager.findPartnerById(id);
		
		PartnerRepresentation partRep = new PartnerRepresentation();
		partRep.setPartnerName(partner.getPartnerName());
		partRep.setPartnerInfo(partner.getPartnerInfo());
		partRep.setPartnerID(partner.getpartnerId());
		
		return partRep;
	}
	

	public PartnerRepresentation addPartner(String name, String partnerInfo){
		
		Partner partner = partnerManager.addPartner(name,partnerInfo);
		PartnerRepresentation partRep = new PartnerRepresentation();	
		partRep.setPartnerID(partner.getpartnerId());
		partRep.setPartnerInfo(partner.getPartnerInfo());
		partRep.setPartnerName(partner.getPartnerName());
		
		getPartnerLinks(partRep);
		return partRep;
	}
	
	public String deletePartner(String id) {
		partnerManager.removePartner(id);
				
		return "OK";
	}
	 
	

	
	private void getPartnerLinks(PartnerRepresentation partnerRep) { // get PartnerID
		// then look at the partner products
		Link viewPartner = new Link("view_Partner","http://localhost:8081/partner/{partnerID}", "application/xml");	
		partnerRep.setLinks(viewPartner);
	}
	
	private void viewPartners(PartnerRepresentation partnerRep) { 
		
		Link viewPartner = new Link("view_Partners","http://localhost:8081/partners", "application/xml");	
		partnerRep.setLinks(viewPartner);
	}
}
