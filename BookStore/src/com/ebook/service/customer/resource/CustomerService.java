package com.ebook.service.customer.resource;

import java.util.Set;

import javax.jws.WebService;

import com.ebook.service.customer.representation.CustomerRepresentation;
import com.ebook.service.customer.representation.CustomerRequest;

@WebService
public interface CustomerService {

	public Set<CustomerRepresentation> getAllCustomers();
	public CustomerRepresentation getCustomerById(String customerId);
	public CustomerRepresentation addCustomer(CustomerRequest customerRequest);

}
