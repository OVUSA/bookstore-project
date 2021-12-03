package com.ebook.service.item.resource;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CorsHeaderConstants;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.apache.cxf.rs.security.cors.LocalPreflight;

import com.ebook.service.item.representation.ProductRepresentation;
import com.ebook.service.item.representation.ProductRequest;
import com.ebook.service.item.workflow.ProductActivity;

@CrossOriginResourceSharing(
        allowOrigins = {"http://localhost:8080/"}, 
        allowCredentials = true,
        		allowHeaders = {        				
                    "'Accept': 'application/json'",
                    "'Content-Type': 'application/json'"                
        		        }        		         
)
@Path("/productservice/")
public class ProductResource implements ProductService {

	@Context
	private HttpHeaders headers;	
	
	@OPTIONS
	@Path("/producservice/product")
    @LocalPreflight
    public Response options() {
        String origin = headers.getRequestHeader("Origin").get(0);
        
        if("http://localhost:8080/".equals(origin)) {return Response.ok()
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "POST, PUT, GET")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_CREDENTIALS, "true")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "*")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_HEADERS, "Content-Type")
                           .build();
        }else {
        	return Response.ok().build();
        }       
    }

	@GET
	@Produces({"application/json" , "application/xml"})
	@Path("/product")
	public Set<ProductRepresentation> getAllProducts() {
		// response.addHeader("Access-Control-Allow-Origin", "*");
		System.out.println("GET METHOD Request from Client for All Products................. ");
		ProductActivity pActivity = new ProductActivity();
		return pActivity.getAllProducts();
	}
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
