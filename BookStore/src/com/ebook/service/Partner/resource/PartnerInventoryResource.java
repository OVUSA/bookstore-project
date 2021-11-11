package com.ebook.service.Partner.resource;

import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;

import com.ebook.model.service.Partner.representation.PartnerRepresentation;
import com.ebook.model.service.Partner.representation.PartnerRequest;
import com.ebook.model.service.Partner.workflow.PartnerActivity;
import com.ebook.service.Partner.workflow.PartnerInventoryActivity;
import com.ebook.service.item.representation.ProductRepresentation;
import com.ebook.service.item.representation.ProductRequest;
import com.ebook.service.item.workflow.ProductActivity;
@Path("/partnerInventoryservice/")
public class PartnerInventoryResource {
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partner_products")
	public Set<ProductRepresentation> getAllProducts() {
		System.out.println("GET METHOD Request for all Partner products .............");
		PartnerInventoryActivity partnerInvActivity = new PartnerInventoryActivity();
		return partnerInvActivity.getPartnerProducts();	
	}
	

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/partner_product")
	public ProductRepresentation createProduct(ProductRequest  productRequest) {
		System.out.println("POST METHOD Request from Client with ............." + productRequest.getTitle() + "  " + productRequest.getDescription() + " " + productRequest.getPrice() + " " + productRequest.getAuthor());
		PartnerInventoryActivity partnerInvActivity = new PartnerInventoryActivity();
		return partnerInvActivity.addProduct(productRequest.getTitle(),
				productRequest.getDescription(), productRequest.getPrice(), productRequest.getAuthor());
	}
	
}


		
	




