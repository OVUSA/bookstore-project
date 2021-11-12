package com.ebook.service.Partner.resource;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.ebook.service.Partner.representation.PartnerRepresentation;
import com.ebook.service.Partner.representation.PartnerRequest;

@WebService
public interface PartnerService {
	   
	public Set<PartnerRepresentation> getPartners();
	public PartnerRepresentation createPartner(PartnerRequest partnRequest);
	public PartnerRepresentation getPartnerByID(String partnerID);
	public Response deletePartner(String partnerID);
	
}
