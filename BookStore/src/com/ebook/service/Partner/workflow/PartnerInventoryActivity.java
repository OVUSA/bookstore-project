package com.ebook.service.Partner.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.ebook.model.item.Product;
import com.ebook.model.link.Link;
import com.ebook.model.partner.Partner;
import com.ebook.model.partner.PartnerInventory;
import com.ebook.model.partner.PartnerManager;
import com.ebook.service.Partner.representation.PartnerInventoryRepresentation;
import com.ebook.service.Partner.representation.PartnerInventoryRequest;
import com.ebook.service.item.representation.ProductRepresentation;

public class PartnerInventoryActivity {

	private PartnerManager partnerManager = new PartnerManager();

	public Set<PartnerInventoryRepresentation> getPartnerProducts(String id) {// Vendor's id
		
		Partner part = partnerManager.findPartnerById(id);
		List<PartnerInventory> partnerProducts = part.getInventory();	
		Set<PartnerInventoryRepresentation> partnerInvRepresentation = new HashSet<PartnerInventoryRepresentation>();
		
		Iterator<PartnerInventory> it = partnerProducts.iterator();
		while(it.hasNext()) {
			  PartnerInventory p = it.next();
			  Product pr = p.getProduct();
			  int qn = p.getQuantity();
			  
			  ProductRepresentation productRep = new ProductRepresentation();
			  productRep.setAuthor(pr.getAuthor());
			  productRep.setDescription(pr.getDescription());
			  productRep.setPrice(pr.getPrice());
			  productRep.setTitle(pr.getTitle());
			  productRep.setproductId(pr.getproductId());
	                
			  PartnerInventoryRepresentation PartnerInventoryRepresentation = new PartnerInventoryRepresentation(productRep,qn);
	          partnerInvRepresentation.add(PartnerInventoryRepresentation);
	          
	          deleteProduct(PartnerInventoryRepresentation);
	        }	
		
		
		return partnerInvRepresentation;
	}


	public PartnerInventoryRepresentation addPartnerProduct(PartnerInventoryRequest  productInvRequest,String partnerId) {
		
		Product prod = partnerManager.addPartnerProduct(partnerId, productInvRequest.getTitle(), productInvRequest.getDescription(), +
				+ productInvRequest.getPrice(), productInvRequest.getAuthor(),productInvRequest.getQuantity());	
			
		ProductRepresentation pr = new ProductRepresentation();
		pr.setAuthor(prod.getAuthor());
		pr.setDescription(prod.getDescription());
		pr.setPrice(prod.getPrice());
		pr.setproductId(prod.getproductId());
		pr.setTitle(prod.getTitle());

		PartnerInventoryRepresentation prI = new PartnerInventoryRepresentation (pr,productInvRequest.getQuantity());
		return prI ;
	}
	
	public String removePartnerProduct(String productId) {
		partnerManager.deleteProduct(productId);
		return "OK";
	}

	
	
	private void addPartnerProductLinks() { 
			
		Link addProduct = new Link("view_Partner","http://localhost:8081/partner_product", "application/xml");	
		PartnerInventoryRepresentation partnerInvRep = new PartnerInventoryRepresentation();
		partnerInvRep.setLinks(addProduct);
	}
	
	private void viewPartnerProductLinks() { 
		
		Link addProduct = new Link("view_Partner_Products","http://localhost:8081/partner_products", "application/xml");	
		PartnerInventoryRepresentation partnerInvRep = new PartnerInventoryRepresentation();
		partnerInvRep.setLinks(addProduct);
	}
	
	private void deleteProduct(PartnerInventoryRepresentation partnerInvent) {
		Link deleteProduct = new Link ("delete_product","http://localhost:8081/partnerservice/{partnerId}/{productId}","application/xml");
		partnerInvent.setLinks(deleteProduct);
	}
}
