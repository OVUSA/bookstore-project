package com.ebook.service.item.resource;

import java.util.Set;

import javax.jws.WebService;

import com.ebook.service.item.representation.ProductRepresentation;
import com.ebook.service.item.representation.ProductRequest;

@WebService
public interface ProductService {

	public Set<ProductRepresentation> getAllProducts();
	public ProductRepresentation getProductById(String productId);
	public ProductRepresentation createProduct(ProductRequest ProductRequest);

}
