package com.ebook.model.customer;

import java.util.Set;

public interface ICustomerManager {

	public Set<Customer> getAllCustomers();
	
	public Customer getCustomerById(String customerId);
	
	public Customer AddCustomer(String firstName, String lastName, String billingAddress, String shippingAddress);
	
	public void UpdateCustomer(String firstName, String lastName, String billingAddress, String shippingAddress);
	
	public void RemoveCustomer(String customerId);
}
