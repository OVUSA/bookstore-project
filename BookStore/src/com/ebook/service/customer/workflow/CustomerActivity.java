package com.ebook.service.customer.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.ebook.model.customer.Address;
import com.ebook.model.customer.Customer;
import com.ebook.model.customer.CustomerManager;
import com.ebook.model.order.Order;
import com.ebook.service.customer.representation.CustomerRepresentation;
import com.ebook.service.customer.representation.CustomerRequest;

public class CustomerActivity {
	
	private static CustomerManager cm = new CustomerManager();

	public Set<CustomerRepresentation> getAllCustomers() {
		
		Set<Customer> customers = new HashSet<Customer>();
		Set<CustomerRepresentation> customerRepresentations = new HashSet<CustomerRepresentation>();
		customers = cm.getAllCustomers();
		
		Iterator<Customer> it = customers.iterator();
		while(it.hasNext()) {
          Customer cust = (Customer)it.next();
          CustomerRepresentation customerRepresentation = new CustomerRepresentation();
          customerRepresentation.setcustomerId(cust.getcustomerId());
          customerRepresentation.setfirstName(cust.getfirstName());
          customerRepresentation.setlastName(cust.getlastName());
          customerRepresentation.setbillingAddress(cust.getbillingAddress());
          customerRepresentation.setshippingAddress(cust.getshippingAddress());
          customerRepresentation.setOrders(cust.getOrders());
          
          //now add this representation in the list
          customerRepresentations.add(customerRepresentation);
        }
		return customerRepresentations;
	}
	
	public CustomerRepresentation getCustomerById(String customerId) {
		
		Customer cust = cm.getCustomerById(customerId);
		
		CustomerRepresentation custRep = new CustomerRepresentation();
		custRep.setcustomerId(cust.getcustomerId());
		custRep.setfirstName(cust.getfirstName());
		custRep.setlastName(cust.getlastName());
		custRep.setbillingAddress(cust.getbillingAddress());
		custRep.setshippingAddress(cust.getshippingAddress());
		custRep.setOrders(cust.getOrders());
		
		return custRep;
	}
	
	public CustomerRepresentation addCustomer(CustomerRequest customerRequest ){
		
		Customer cust = cm.addCustomer(customerRequest);
				
		CustomerRepresentation custRep = new CustomerRepresentation();
		custRep.setcustomerId(cust.getcustomerId());
		custRep.setfirstName(cust.getfirstName());
		custRep.setlastName(cust.getlastName());
		custRep.setbillingAddress(cust.getbillingAddress());
		custRep.setshippingAddress(cust.getshippingAddress());
		custRep.setOrders(cust.getOrders());
			
		return custRep;
	}
	
	public String deleteCustomer(String customerId) {
		cm.deleteCustomer(customerId);
		
		return "OK";
	}
}
