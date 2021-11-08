package com.ebook.model.service.Partner.workflow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.ebook.model.item.Product;
import com.ebook.model.partner.PartnerInventoryManager;
import com.ebook.service.item.representation.ProductRepresentation;

public class PartnerInventoryActivity {

	private static PartnerInventoryManager partnerInventoryManager = new PartnerInventoryManager();

	public Set<ProductRepresentation> getPartnerProducts() {

		Set<ProductRepresentation> ProductRepresentations = new HashSet<ProductRepresentation>();
		List<Product> partnerInvRepresentation = new ArrayList<Product>();
		partnerInvRepresentation = partnerInventoryManager.reviewAllProducts();

		Iterator<Product> it = partnerInvRepresentation.iterator();
		while(it.hasNext()) {
			Product p = (Product)it.next();
			ProductRepresentation ProductRepresentation = new ProductRepresentation();
			ProductRepresentation.setTitle(p.getTitle());
			ProductRepresentation.setPrice(p.getPrice());
			ProductRepresentation.setDescription(p.getDescription());
			ProductRepresentation.setAuthor(p.getAuthor());


			ProductRepresentations.add(ProductRepresentation);
		}
		return ProductRepresentations;
	}



	public ProductRepresentation addProduct(String prodTitle, String prodDesc, double prodprice, String prodAuthor) {
		Product p = new Product(prodTitle, prodDesc, prodprice, prodAuthor, null);

		partnerInventoryManager.addProduct(p,1);

		ProductRepresentation pRep = new ProductRepresentation();
		pRep.setTitle(p.getTitle());
		pRep.setDescription(p.getDescription());
		pRep.setPrice(p.getPrice());
		pRep.setAuthor(p.getAuthor());

		return pRep;
	}
}
