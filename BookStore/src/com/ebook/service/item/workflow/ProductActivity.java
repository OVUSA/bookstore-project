package com.ebook.service.item.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.ebook.model.item.Product;
import com.ebook.model.item.ProductManager;
import com.ebook.service.item.representation.ProductRepresentation;
import com.ebook.service.item.representation.ProductRequest;

public class ProductActivity {
	
	private static ProductManager pm = new ProductManager();

	public Set<ProductRepresentation> getAllProducts() {
		
		Set<Product> products = new HashSet<Product>();
		Set<ProductRepresentation> ProductRepresentations = new HashSet<ProductRepresentation>();
		products = pm.getAllProducts();
		
		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
	          Product p = (Product)it.next();
	          ProductRepresentation ProductRepresentation = new ProductRepresentation();
	          ProductRepresentation.setproductId(p.getproductId());
	          ProductRepresentation.setTitle(p.getTitle());
	          ProductRepresentation.setPrice(p.getPrice());
	          ProductRepresentation.setDescription(p.getDescription());
	          ProductRepresentation.setAuthor(p.getAuthor());
	          
	          ProductRepresentations.add(ProductRepresentation);
	        }
		return ProductRepresentations;
		
	}
	
	public ProductRepresentation getProductById(String productId) {
		
		Product product = pm.getProductById(productId);
		
		ProductRepresentation pRep = new ProductRepresentation();
		pRep.setproductId(product.getproductId());
		pRep.setTitle(product.getTitle());
		pRep.setPrice(product.getPrice());
		pRep.setDescription(product.getDescription());
		pRep.setAuthor(product.getAuthor());
		
		return pRep;
	}
	
	public ProductRepresentation createProduct(ProductRequest productRequest) {	
		Product p = pm.AddProduct(productRequest);
		
		ProductRepresentation pRep = new ProductRepresentation();
		pRep.setproductId(p.getproductId());
		pRep.setTitle(p.getTitle());
		pRep.setDescription(p.getDescription());
		pRep.setPrice(p.getPrice());
		pRep.setAuthor(p.getAuthor());
		
		return pRep;
	}
    
    public String removeProduct(String productId) {
		
		pm.removeProduct(productId);
		
		return "OK";
	}
}