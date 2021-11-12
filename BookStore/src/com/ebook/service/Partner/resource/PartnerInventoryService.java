package com.ebook.service.Partner.resource;

import java.util.Set;
import javax.ws.rs.core.Response;

import com.ebook.service.Partner.representation.PartnerInventoryRepresentation;
import com.ebook.service.Partner.representation.PartnerInventoryRequest;


public interface PartnerInventoryService {
	public Set<PartnerInventoryRepresentation> getAllPartnerProducts();
	public PartnerInventoryRepresentation addPartnerProduct(PartnerInventoryRequest  productInvRequest) ;
	public Response deleteProduct(String productId);

}
