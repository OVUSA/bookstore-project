package com.ebook.service.Partner.resource;

import java.util.Set;

import javax.jws.WebService;

import com.ebook.service.Partner.representation.PartnerRepresentation;

@WebService
public interface PartnerService {
	   
	public Set<PartnerRepresentation> getPartners();
	public PartnerRepresentation getPartner(int Id);
	public void deletePartner(String id);

   
    

}
