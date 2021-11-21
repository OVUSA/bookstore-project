package com.ebook.service.Partner.workflow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.ebook.model.item.Product;
import com.ebook.model.link.Link;
import com.ebook.model.partner.PartnerInventory;
import com.ebook.model.partner.PartnerInventoryManager;
import com.ebook.service.Partner.representation.PartnerInventoryRepresentation;
import com.ebook.service.Partner.representation.PartnerRepresentation;

public class PartnerInventoryActivity {

	private static PartnerInventoryManager partnerInventoryManager = new PartnerInventoryManager();

	public List<PartnerInventoryRepresentation> getPartnerProducts() {

		Set<PartnerInventory> partnerProducts = new HashSet<PartnerInventory>();
		List<PartnerInventoryRepresentation> partnerInvRepresentation = new ArrayList<PartnerInventoryRepresentation>();
		partnerProducts = (Set<PartnerInventory>) partnerInventoryManager.reviewAllPartnerProducts();

		Iterator<PartnerInventory> it = partnerProducts.iterator();
		while(it.hasNext()) {
			  PartnerInventory p = (PartnerInventory)it.next();
			  Product pr = p.getProduct();
			  PartnerInventoryRepresentation PartnerInventoryRepresentation = new PartnerInventoryRepresentation();
	          PartnerInventoryRepresentation.setTitle(pr.getTitle());
	          PartnerInventoryRepresentation.setPrice(pr.getPrice());
	          PartnerInventoryRepresentation.setDescription(pr.getDescription());
	          PartnerInventoryRepresentation.setAuthor(pr.getAuthor());
	          
	          partnerInvRepresentation.add(PartnerInventoryRepresentation);
	        }
		addPartnerProductLinks(); // add product
		
		
		return partnerInvRepresentation;
	}


	public PartnerInventoryRepresentation addPartnerProduct(String prodTitle, String prodDesc, double prodprice, String prodAuthor,int quantity) {
		
		PartnerInventory partInv = partnerInventoryManager.addPartnerProduct(prodTitle, prodDesc, prodprice, prodAuthor, quantity);

		PartnerInventoryRepresentation pInvRep = new PartnerInventoryRepresentation();
		Product p = partInv.getProduct();
		pInvRep .setTitle(p.getTitle());
		pInvRep .setDescription(p.getDescription());
		pInvRep .setPrice(p.getPrice());
		pInvRep .setAuthor(p.getAuthor());
		
		viewPartnerProductLinks();// view all products

		return pInvRep ;
	}
	
	public String removePartnerProduct(String id) {
		partnerInventoryManager.deletePartnerProduct(id);
		return "OK";
	}
	
	private void addPartnerProductLinks() { 
			
		Link addProduct = new Link("view_Partner","http://localhost:8081/partner_product", "application/xml");	
		PartnerInventoryRepresentation partnerInvRep = new PartnerInventoryRepresentation();
		partnerInvRep.setLinks(addProduct);
	}
	
	private void viewPartnerProductLinks() { 
		
		Link addProduct = new Link("view_Partner_Products","http://localhost:8081//partner_products", "application/xml");	
		PartnerInventoryRepresentation partnerInvRep = new PartnerInventoryRepresentation();
		partnerInvRep.setLinks(addProduct);
	}
}
