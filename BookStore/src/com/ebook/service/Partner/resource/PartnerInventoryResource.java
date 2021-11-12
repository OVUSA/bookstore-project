package com.ebook.service.Partner.resource;

import java.util.Set;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.ebook.service.Partner.representation.PartnerInventoryRepresentation;
import com.ebook.service.Partner.representation.PartnerInventoryRequest;
import com.ebook.service.Partner.workflow.PartnerInventoryActivity;
import com.ebook.service.item.workflow.ProductActivity;

@Path("/partnerInventoryservice/")
public class PartnerInventoryResource implements PartnerInventoryService{
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partner_products")
	public Set<PartnerInventoryRepresentation> getAllPartnerProducts() {
		System.out.println("GET METHOD Request for all Partner products .............");
		PartnerInventoryActivity partnerInvActivity = new PartnerInventoryActivity();
		return (Set<PartnerInventoryRepresentation>) partnerInvActivity.getPartnerProducts();	
	}
	

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/partner_product")
	public PartnerInventoryRepresentation addPartnerProduct(PartnerInventoryRequest  productInvRequest) {
		System.out.println("POST METHOD Request from Client with ............." + productInvRequest.getTitle() + "  " + productInvRequest.getDescription() + " " + productInvRequest.getPrice() + " " + productInvRequest.getAuthor());
		PartnerInventoryActivity partnerInvActivity = new PartnerInventoryActivity();
		return partnerInvActivity.addPartnerProduct(productInvRequest.getTitle(),
				productInvRequest.getDescription(),productInvRequest.getPrice(), productInvRequest.getAuthor(),productInvRequest.getQuantity());
	}
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/partner_products/{productId}")
	public Response deleteProduct(@PathParam("productId") String productId) {
		System.out.println("Delete METHOD Request from Client with productRequest String ............." + productId);
		// remove from marketplace
		ProductActivity pActivity = new ProductActivity();
		String res = pActivity.removeProduct(productId);
		
		//remove from partner Inventory
		PartnerInventoryActivity piA= new  PartnerInventoryActivity();
		piA.removePartnerProduct(productId);
		
				if (res.equals("OK")&& piA.equals("OK")) {
			
			return Response.status(Status.OK).build();
		}
		return null;
	}	
	
}


		
	




