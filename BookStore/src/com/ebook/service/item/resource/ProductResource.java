package com.ebook.service.item.resource;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ebook.service.item.representation.ProductRepresentation;
import com.ebook.service.item.representation.ProductRequest;
import com.ebook.service.item.workflow.ProductActivity;

@Path("/productservice/")
public class ProductResource implements ProductService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/product")
	public Set<ProductRepresentation> getAllProducts() {
		System.out.println("GET METHOD Request for all Products .............");
		ProductActivity pActivity = new ProductActivity();
		return pActivity.getAllProducts();	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/product/{productId}")
	public ProductRepresentation getProductById(@PathParam("productId") String productId) {
		System.out.println("GET METHOD Request from Client with ProductRequest String ............." + productId);
		ProductActivity pActivity = new ProductActivity();
		return pActivity.getProductById(productId);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/product")
	public ProductRepresentation createProduct(ProductRequest  productRequest) {
		System.out.println("POST METHOD Request from Client with ............." + productRequest.getTitle() + "  " + productRequest.getDescription() + " " + productRequest.getPrice() + " " + productRequest.getAuthor());
		ProductActivity pActivity = new ProductActivity();
		return pActivity.createProduct(productRequest);
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/product/{productId}")
	public Response deleteProduct(@PathParam("productId") String productId) {
		System.out.println("Delete METHOD Request from Client with productRequest String ............." + productId);
		ProductActivity pActivity = new ProductActivity();
		String res = pActivity.removeProduct(productId);
		if (res.equals("OK")) {
			
			return Response.status(Status.OK).build();
		}
		return null;
	}	
}
