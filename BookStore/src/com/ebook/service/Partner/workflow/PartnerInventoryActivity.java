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
	          
	          placeOrder(productRep);
	         // deleteProduct(PartnerInventoryRepresentation,productRep.getproductId(), part.getpartnerId());
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
		
		viewPartnerProductLink(prI, partnerId);		
		return prI ;
			
	}
	
	public String removePartnerProduct(String productId) {
		partnerManager.deleteProduct(productId);
		return "OK";
	}
	
	private void addPartnerProductLinks() { 
			
		Link addProduct = new Link("view_Partner","http://localhost:8080/partnerservice/partner_product", "application/xml");	
		PartnerInventoryRepresentation partnerInvRep = new PartnerInventoryRepresentation();
		partnerInvRep.setLinks(addProduct);
	}
	
	private void viewPartnerProductLink(PartnerInventoryRepresentation partnerInvent, String partnerID ) {
		Link viewPartnerProducts = new Link("http://localhost:8080/partnerservice/"+partnerID+ "/partner_products","view_products","application/xml");
		partnerInvent.setLinks(viewPartnerProducts);
	}
	
	private void deleteProduct(PartnerInventoryRepresentation partnerInvent, String productID, String partnerID) {
		Link deleteProduct = new Link ("http://localhost:8080/partnerservice/"+partnerID+"/"+productID,"delete_product","application/xml");
		partnerInvent.setLinks(deleteProduct);
	}
	
	
	private void placeOrder(ProductRepresentation product) { 
		Link placeOrder = new Link("http://localhost:8080/orderservice/order","buy_product", "application/xml");	
		product.setLinks(placeOrder);
		
	}
}
