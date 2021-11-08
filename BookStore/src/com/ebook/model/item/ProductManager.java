package com.ebook.model.item;

import java.util.Set;

import com.ebook.dal.ProductDAO;
//import com.ebook.model.item.Product;
import com.ebook.service.item.representation.ProductRequest;


public class ProductManager implements IProductManager {
	
	
	private static ProductDAO productDAO = new ProductDAO();
	
	@Override
	public Set<Product> getAllProducts(){
        
           return productDAO.getAllProducts();
        
    }
    
	@Override
    public Product getProductById(String productId){
        
            return productDAO.getProductById(productId);     
    }
    
	@Override
	public Product AddProduct(ProductRequest productRequest){
    	
    	Product pm = productDAO.AddProduct(productRequest);
    	
		
		return pm;
    }
	
	@Override
    public void UpdateProduct(ProductRequest productRequest){
		
    	productDAO.UpdateProduct(productRequest);  
    	
    }

    public void removeProduct(String productId){
    
            productDAO.removeProduct(productId);
    }
    
}