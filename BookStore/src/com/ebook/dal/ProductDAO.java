package com.ebook.dal;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import com.ebook.model.item.Product;
import com.ebook.service.item.representation.ProductRequest;

public class ProductDAO {

   private static Set<Product> products = new HashSet<Product>();
	
	public ProductDAO() {
	        
			Product product1 = new Product();
		    
			product1.setproductId("XY1111");
			product1.setTitle("Mocking Jay");
			product1.setDescription("Book on Mocking Jay");
			product1.setPrice(2350);
			product1.setAuthor("John Smith");
		
			products.add(product1);
			
			Product product2 = new Product();
			product2.setproductId("XY1112");
			product2.setTitle("Mocking Jay Part 2");
			product2.setDescription("Series book on Mocking Jay");
			product2.setPrice(2353);
			product2.setAuthor("John Smith");
		
			products.add(product2);
		
	}
	
	public Set<Product> getAllProducts(){

		return products;
	}
	
	public Product getProductById(String productId) {

		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
          Product prod = (Product)it.next();
          if (prod.getproductId().equals(productId)) {
        	  return prod;
          }
        }
		return null;
	}

	public Product AddProduct(ProductRequest productRequest) {
        Product product = new Product();
		
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(10000);
	    long randomLong = randomGenerator.nextLong();
	    String productId = "XY" + randomInt;
	    
	    product.setproductId(productId);
	    product.setTitle(productRequest.getTitle());
		product.setDescription(productRequest.getDescription());
		product.setPrice(productRequest.getPrice());
		product.setAuthor(productRequest.getAuthor());	
		products.add(product);
		
		return product;
	}
	
	public void UpdateProduct(ProductRequest productRequest) {		

		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
          Product p = (Product)it.next();
          if (p.getproductId().equals(productRequest.getproductId())) {
        	  p.setTitle(productRequest.getTitle());
        	  p.setDescription(productRequest.getDescription());
        	  p.setPrice(productRequest.getPrice());
        	  p.setAuthor(productRequest.getAuthor());
        	  return;
          }
        }
	}
	public void removeProduct(String productId) {

		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
          Product p = (Product)it.next();
          if (p.getproductId().equals(productId)) {
        	  products.remove(p);
        	  return;
          }
		}
	}
        
    
 public static Product AddPartnerProduct(ProductRequest productRequest) {
 Product product = new Product();
		
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(10000);
	    String productId = "PB" + randomInt;
	    
	  product.setproductId(productId);
	  product.setTitle(productRequest.getTitle());
		product.setDescription(productRequest.getDescription());
		product.setPrice(productRequest.getPrice());
		product.setAuthor(productRequest.getAuthor());
	
		products.add(product);
		
		return product;
	}
}
