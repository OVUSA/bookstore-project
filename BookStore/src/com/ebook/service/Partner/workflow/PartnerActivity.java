package com.ebook.service.Partner.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import com.ebook.model.link.Link;
import com.ebook.model.partner.Partner;
import com.ebook.model.partner.PartnerInventory;
import com.ebook.model.partner.PartnerManager;
import com.ebook.service.Partner.representation.PartnerInventoryRepresentation;
import com.ebook.service.Partner.representation.PartnerRepresentation;
import com.ebook.service.item.representation.ProductRepresentation;


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
			
			getPartnerLink(partRep,partRep.getPartnerID());// view individual vendor
		   //deletePartnerLink(partRep);		
		}		
		return partnersRepresentations;
     }

	
	public PartnerRepresentation getPartnerById(String id) {
		Partner partner = PartnerManager.findPartnerById(id);
		partner.getInventory();
		
		
		
		PartnerRepresentation partRep = new PartnerRepresentation();
		partRep.setPartnerName(partner.getPartnerName());
		partRep.setPartnerInfo(partner.getPartnerInfo());
		partRep.setPartnerID(partner.getpartnerId());
		
		if (partRep.getInventory()!= null) { // check if inventory is empty
		for (PartnerInventory i :partRep.getInventory()) {
			PartnerInventoryRepresentation pip=new PartnerInventoryRepresentation ();
			ProductRepresentation pr= new ProductRepresentation();
			pr.setAuthor(i.getProduct().getAuthor());
			pr.setTitle(i.getProduct().getTitle());
			
			pip.setProduct(pr);
			pip.setQuantity(i.getQuantity());
			
			// hateoas
			viewPartnerProducts(pip,partRep.getPartnerID());		
			}
		}else {
			addProduct(partRep,partRep.getPartnerID());
			
		}
		
	
		//links
		//viewAllPartners(partRep);
		//deletePartnerLink(partRep);
		return partRep;
	}
	

	public PartnerRepresentation addPartner(String name, String partnerInfo){
		
		Partner partner = partnerManager.addPartner(name,partnerInfo);
		PartnerRepresentation partRep = new PartnerRepresentation();	
		partRep.setPartnerID(partner.getpartnerId());
		partRep.setPartnerInfo(partner.getPartnerInfo());
		partRep.setPartnerName(partner.getPartnerName());
		
		getPartnerLink(partRep,partRep.getPartnerID());// view individual vendor
		deletePartnerLink(partRep,partRep.getPartnerID());			
		return partRep;
	}
	
	public String deletePartner(String id) {
		PartnerRepresentation partRep = new PartnerRepresentation();	
		partnerManager.removePartner(id);
		
		viewAllPartners(partRep);				
		return "OK";			
	}
	 
	
	// HATEOAS
	private void getPartnerLink(PartnerRepresentation partnerRep, String partnerId) { //ONE PARTNER
		// then look at the partner products
		Link viewPartner = new Link("http://localhost:8080/partnerservice/partner/"+ partnerId,"view_a_partner","application/xml");	
		partnerRep.setLinks(viewPartner);
	}
	
	private void viewAllPartners(PartnerRepresentation partnerRep) { // ALL PARTNERS
		
		Link viewPartner = new Link("http://localhost:8080/partnerservice/partners","view_All_Partners", "application/xml");	
		partnerRep.setLinks(viewPartner);
	}
	
	private void deletePartnerLink(PartnerRepresentation partnerRep,String partnerID ) {
		
		Link deletePartner = new Link("http://localhost:8080/partnerservice/partner/"+partnerID,"delete_the_partner","application/xml" );	
		partnerRep.setLinks(deletePartner);
	}
	private void viewPartnerProducts(PartnerInventoryRepresentation partnerInvent, String partnerID ) {
		Link viewPartnerProducts = new Link("http://localhost:8080/partnerservice/"+partnerID+ "/partner_products","view_products","application/xml");
		partnerInvent.setLinks(viewPartnerProducts);
	}
	
	private void addProduct(PartnerRepresentation partRep, String partnerID ) {
		Link addProduct = new Link("http://localhost:8080/partnerservice/"+partnerID+"/partner_product","add_product","application/xml");
		partRep.setLinks(addProduct);
	}
	//http://localhost:8080/partnerservice/PI123/partner_product
}
