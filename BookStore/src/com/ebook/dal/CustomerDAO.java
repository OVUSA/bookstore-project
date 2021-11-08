package com.ebook.dal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.ebook.model.customer.Address;
import com.ebook.model.customer.Customer;
import com.ebook.model.item.Book;
import com.ebook.model.order.Order;
import com.ebook.model.order.Payment;
import com.ebook.model.service.customer.representation.CustomerRequest;

public class CustomerDAO {
	
	private static Set<Customer> customers = new HashSet<Customer>();

	public CustomerDAO() {
		Customer customer = new Customer();
		
		Address billingAddress = new Address();
        billingAddress.setStreet("500 West Madison St.");
        billingAddress.setUnit("Suite 1000");
        billingAddress.setCity("Chicago");
        billingAddress.setState("IL");
        billingAddress.setZip("66610");
        
        Address shippingAddress = new Address();
    	shippingAddress.setStreet("500 West Madison St.");
    	shippingAddress.setUnit("Suite 1000");
    	shippingAddress.setCity("Chicago");
    	shippingAddress.setState("IL");
    	shippingAddress.setZip("66610");
    	
    	// build orders info
    	List<Order> orders = new ArrayList<Order> (); 
    	
    	Order order1 = new Order();
        order1.setOrderId("BO-66734");        
        //First product
        Book product1 = new Book();
        product1.setproductId("BF-7898");
        product1.setISBN("234-89675-27690");
        product1.setTitle("Patterns of Enterprise Application Architecture");
        product1.setAuthor("Folwer, Martin");
        product1.setPrice(50.99);        
        order1.addProduct(product1, 1);        
        //Second product
        Book product2 = new Book();
        product2.setproductId("BF-2345");
        product2.setISBN("892-12345-93667");
        product2.setTitle("Web Application Architecture");
        product2.setAuthor("Shklar, Leon");
        product2.setPrice(45.99);
        order1.addProduct(product2, 1);
        //Third product
        Book product3 = new Book();
        product3.setproductId("BF-234212");
        product3.setISBN("892-123445-93667");
        product3.setTitle("testingar Architecture");
        product3.setAuthor("gmg, dogecoin");
        product3.setPrice(155.99);
        order1.addProduct(product3, 1);
        
        //finish order	        
        order1.confirmOrder();
        
        // build payment info
        Payment payment = new Payment();
        payment.setPaymentId(new Long("1234"));
        payment.setPaymentStatus("Paid");
        payment.setPaymentType("CreditCard");
        payment.setSubTotal(order1.getOrderTotal());        
        order1.setPayment(payment);
        
        order1.orderPayed();
        orders.add(order1);	    
        
		customer.setcustomerId("XY1111");
		customer.setfirstName("John");
		customer.setlastName("Smith");
		customer.setbillingAddress(billingAddress);
		customer.setshippingAddress(shippingAddress);
		customer.setOrders(orders);
	
		customers.add(customer);
	}
	
	public Set<Customer> getAllCustomers(){
		return customers;
	}
	
	public Customer getCustomerById(String customerId) {
		Iterator<Customer> it = customers.iterator();
		while(it.hasNext()) {
          Customer cust = (Customer)it.next();
          if (cust.getcustomerId().equals(customerId)) {
        	  return cust;
          }
        }
		return null;
	}

	public Customer addCustomer(CustomerRequest customerRequest){
		Customer customer = new Customer();
		
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(10000);
	    long randomLong = randomGenerator.nextLong();
	    String customerId = "XY" + randomInt;
	    
		customer.setcustomerId(customerId);
		customer.setfirstName(customerRequest.getfirstName());
		customer.setlastName(customerRequest.getlastName());
		customer.setbillingAddress(customerRequest.getbillingAddress());
		customer.setshippingAddress(customerRequest.getshippingAddress());
		customer.setOrders(customerRequest.getOrders());
	
		customers.add(customer);
		
		return customer;
	}
	
	public void updateCustomer(CustomerRequest customerRequest) {
		Iterator<Customer> it = customers.iterator();
		while(it.hasNext()) {
          Customer cust = (Customer)it.next();
          if (cust.getcustomerId().equals(customerRequest.getcustomerId())) {
        	  cust.setfirstName(customerRequest.getfirstName());
        	  cust.setlastName(customerRequest.getlastName());
        	  cust.setbillingAddress(customerRequest.getbillingAddress());
        	  cust.setshippingAddress(customerRequest.getshippingAddress());
        	  cust.setOrders(customerRequest.getOrders());
        	  
        	  return;
          }
        }
	}
	
	public void deleteCustomer(String customerId) {
		Iterator<Customer> it = customers.iterator();
		while(it.hasNext()) {
          Customer cust = (Customer)it.next();
          if (cust.getcustomerId().equals(customerId)) {
        	  customers.remove(cust);
        	  return;
          }
        }
	}
	

}
