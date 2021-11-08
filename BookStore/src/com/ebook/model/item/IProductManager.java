package com.ebook.model.item;

import java.util.Set;

import com.ebook.service.item.representation.ProductRequest;

public interface IProductManager {
	
	public Set<Product> getAllProducts();
	
	public Product getProductById(String productId);

	public Product AddProduct(ProductRequest productrequest);
	
	public void UpdateProduct(ProductRequest productrequest);

}
