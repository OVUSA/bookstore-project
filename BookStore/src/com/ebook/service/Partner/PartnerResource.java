package com.ebook.model.service.Partner;

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


@Path("/partnerservice/")
public class PartnerResource {
	
		
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partner/{partnerID}")
	public PartnerRepresentation getPartnerByID(@PathParam("partnerID") String partnerID) {
		System.out.println("GET METHOD Request from Client to Get Partner");
		PartnerActivity partnerActivity = new PartnerActivity();
		return partnerActivity.getPartnerById(partnerID);
	}
	

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partners")
	public Set<PartnerRepresentation> getPartners() {
		System.out.println("GET METHOD Request for all partners .............");
		PartnerActivity partnerActivity = new PartnerActivity();
		return partnerActivity.getPartners();	
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/partner")
	public PartnerRepresentation createPartner(PartnerRequest partnRequest) {
		System.out.println("POST METHOD Request from Client with ............." + partnRequest.getPartnerName());
		PartnerActivity partnerActivity = new PartnerActivity();
		return partnerActivity.addPartner(partnRequest.getPartnerName(),partnRequest.getPartnerInfo());
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/partner/{partnerID}")
	public Response deletePartner(@PathParam("partnerID") String partnerID) {
		System.out.println("Delete METHOD Request from Client with partner Request String ............." + partnerID);
		PartnerActivity partnerActivity = new PartnerActivity();
		String res = partnerActivity.deletePartner(partnerID);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
}



