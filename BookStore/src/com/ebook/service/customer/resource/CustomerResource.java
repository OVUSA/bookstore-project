package com.ebook.service.customer.resource;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ebook.service.customer.representation.CustomerRepresentation;
import com.ebook.service.customer.representation.CustomerRequest;
import com.ebook.service.customer.workflow.CustomerActivity;

@Path("/customerservice/")
public class CustomerResource implements CustomerService {
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customer")
	public Set<CustomerRepresentation> getAllCustomers() {
		System.out.println("GET METHOD Request for all customers .............");
		CustomerActivity custActivity = new CustomerActivity();
		return custActivity.getAllCustomers();	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/{customerId}")
	public CustomerRepresentation getCustomerById(@PathParam("customerId") String customerId) {
		System.out.println("GET METHOD Request from Client with customerRequest String ............." + customerId);
		CustomerActivity custActivity = new CustomerActivity();
		return custActivity.getCustomerById(customerId);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/customer")
	public CustomerRepresentation addCustomer(CustomerRequest  customerRequest) {
		System.out.println("POST METHOD Request from Client with ............." 
	    + customerRequest.getfirstName() 
		+ "  " + customerRequest.getlastName()+ "  " + customerRequest.getbillingAddress()
		+ "  " + customerRequest.getshippingAddress()
		+ "  " + customerRequest.getOrders());
		CustomerActivity custActivity = new CustomerActivity();
		return custActivity.addCustomer(customerRequest);
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/{customerId}")
	public Response deleteCustomer(@PathParam("customerId") String customerId) {
		System.out.println("Delete METHOD Request from Client with customerRequest String ............." + customerId);
		CustomerActivity custActivity = new CustomerActivity();
		String res = custActivity.deleteCustomer(customerId);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
}
