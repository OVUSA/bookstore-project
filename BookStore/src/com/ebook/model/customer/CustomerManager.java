package com.ebook.model.customer;

import java.util.Set;

import com.ebook.dal.CustomerDAO;
import com.ebook.service.customer.representation.CustomerRequest;

public class CustomerManager {
	
	private static CustomerDAO dao = new CustomerDAO();
	
	public Set<Customer> getAllCustomers(){
		return dao.getAllCustomers();
	}
	
	public Customer getCustomerById(String customerId) {
		return dao.getCustomerById(customerId);
	}

	public Customer addCustomer(CustomerRequest customerRequest){
		
		Customer cust = dao.addCustomer(customerRequest);
		
		return cust;
	}
	
	public void updateCustomer(CustomerRequest customerRequest) {
		dao.updateCustomer(customerRequest);
	}
	
	public void deleteCustomer(String customerId) {
		dao.deleteCustomer(customerId);
	}

}
