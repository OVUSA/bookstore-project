package com.ebook.service.Partner.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import com.ebook.model.link.Link;
import com.ebook.model.partner.Partner;
import com.ebook.model.partner.PartnerManager;
import com.ebook.service.Partner.representation.PartnerInventoryRepresentation;
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
			
			// add representation to the set
			partnersRepresentations.add(partRep);
			
			getPartnerLink(partRep);// view individual vendor
		    deletePartnerLink(partRep);		
		}		
		return partnersRepresentations;
     }

	
	public PartnerRepresentation getPartnerById(String id) {
		Partner partner = PartnerManager.findPartnerById(id);
		partner.getInventory();
		
		PartnerInventoryRepresentation  partInvRep = new PartnerInventoryRepresentation ();
		
		PartnerRepresentation partRep = new PartnerRepresentation();
		partRep.setPartnerName(partner.getPartnerName());
		partRep.setPartnerInfo(partner.getPartnerInfo());
		partRep.setPartnerID(partner.getpartnerId());
		
	
		//links
		//viewAllPartners(partRep);
		//deletePartnerLink(partRep);
		viewPartnerProducts(partInvRep);
		
		return partRep;
	}
	

	public PartnerRepresentation addPartner(String name, String partnerInfo){
		
		Partner partner = partnerManager.addPartner(name,partnerInfo);
		PartnerRepresentation partRep = new PartnerRepresentation();	
		partRep.setPartnerID(partner.getpartnerId());
		partRep.setPartnerInfo(partner.getPartnerInfo());
		partRep.setPartnerName(partner.getPartnerName());
		
		getPartnerLink(partRep);// view individual vendor
		deletePartnerLink(partRep);			
		return partRep;
	}
	
	public String deletePartner(String id) {
		PartnerRepresentation partRep = new PartnerRepresentation();	
		partnerManager.removePartner(id);
		
		viewAllPartners(partRep);				
		return "OK";			
	}
	 
	
	// HATEOAS
	private void getPartnerLink(PartnerRepresentation partnerRep) { // get PartnerID
		// then look at the partner products
		Link viewPartner = new Link("view_a_partner","http://localhost:8080/partner/{partnerID}", "application/xml");	
		partnerRep.setLinks(viewPartner);
	}
	
	private void viewAllPartners(PartnerRepresentation partnerRep) { 
		
		Link viewPartner = new Link("view_All_Partners","http://localhost:8080/partnerservice/partners", "application/xml");	
		partnerRep.setLinks(viewPartner);
	}
	
	private void deletePartnerLink(PartnerRepresentation partnerRep) {
		
		Link deletePartner = new Link("http://localhost:8080/partnerservice/partner/{partnerID}","delete_the_partner","application/xml" );	
		partnerRep.setLinks(deletePartner);
	}
	private void viewPartnerProducts(PartnerInventoryRepresentation partnerInvent) {
		Link viewPartnerProducts = new Link("view_products","http://localhost:8080/partnerservice/{partnerID}/partner_products","application/xml");
		partnerInvent.setLinks(viewPartnerProducts);
	}

}
