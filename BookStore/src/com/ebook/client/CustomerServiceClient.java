package com.ebook.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.ebook.model.customer.Address;
import com.ebook.model.item.Book;
import com.ebook.model.order.Order;
import com.ebook.model.order.Payment;
import com.ebook.service.customer.representation.CustomerRequest;

public class CustomerServiceClient {

	public static void main(String args[]) throws Exception {

	   	 List<Object> providers = new ArrayList<Object>();
	        JacksonJsonProvider provider = new JacksonJsonProvider();
	        provider.addUntouchable(Response.class);
	        providers.add(provider);
	        System.out.println(providers);
	        
	        
	        /*****************************************************************************************
	         * GET METHOD invoke
	         *****************************************************************************************/
	        System.out.println("GET METHOD .........................................................");
	        WebClient getClient = WebClient.create("http://localhost:8080", providers);
	      
	        WebClient.getConfig(getClient).getOutInterceptors().add(new LoggingOutInterceptor());
	        WebClient.getConfig(getClient).getInInterceptors().add(new LoggingInInterceptor());
	        
	        getClient = getClient.accept("application/json").type("application/json").path("/customerservice/customer/XY1111");
	        
	        String getRequestURI = getClient.getCurrentURI().toString();
	        System.out.println("Client GET METHOD Request URI:  " + getRequestURI);
	        String getRequestHeaders = getClient.getHeaders().toString();
	        System.out.println("Client GET METHOD Request Headers:  " + getRequestHeaders);

	        System.out.println(getClient.get());
	        String response = getClient.get(String.class);
	        System.out.println("GET METHOD Response: ...." + response);
	        
	        /*****************************************************************************************
	         * POST METHOD invoke
	        *****************************************************************************************/
	        System.out.println("POST METHOD .........................................................");
	        WebClient postClient = WebClient.create("http://localhost:8080", providers);
	        WebClient.getConfig(postClient).getOutInterceptors().add(new LoggingOutInterceptor());
	        WebClient.getConfig(postClient).getInInterceptors().add(new LoggingInInterceptor());
	                 
	        postClient = postClient.accept("application/xml").type("application/xml").path("/customerservice/customer");
	     	
	        String postRequestURI = postClient.getCurrentURI().toString();
	        System.out.println("Client POST METHOD Request URI:  " + postRequestURI);
	        String postRequestHeaders = postClient.getHeaders().toString();
	        System.out.println("Client POST METHOD Request Headers:  " + postRequestHeaders);
	        CustomerRequest customerRequest = new CustomerRequest();
	        
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
	    	
	    	Order order2 = new Order();
	        order2.setOrderId("BO-66735");        
	        //First product
	        Book product4 = new Book();
	        product4.setproductId("AF-7898");
	        product4.setISBN("134-89675-27690");
	        product4.setTitle("Application Architecture");
	        product4.setAuthor("Hannah, Naiman");
	        product4.setPrice(50.99);        
	        order2.addProduct(product4, 1);        
	        //Second product
	        Book product5 = new Book();
	        product5.setproductId("BF-2345");
	        product5.setISBN("892-12345-93667");
	        product5.setTitle("Web Application Architecture");
	        product5.setAuthor("Shklar, Leon");
	        product5.setPrice(45.99);
	        order2.addProduct(product5, 1);
	        //Third product
	        Book product6 = new Book();
	        product6.setproductId("BF-234212");
	        product6.setISBN("892-123445-93667");
	        product6.setTitle("testingar Architecture");
	        product6.setAuthor("gmg, dogecoin");
	        product6.setPrice(155.99);
	        order2.addProduct(product6, 1);
	        
	        //finish order	        
	        order2.confirmOrder();
	        
	        // build payment info
	        Payment payment = new Payment();
	        payment.setPaymentId(new Long("1234"));
	        payment.setPaymentStatus("Paid");
	        payment.setPaymentType("CreditCard");
	        payment.setSubTotal(order2.getOrderTotal());        
	        order2.setPayment(payment);
	        
	        order2.orderPayed();
	        orders.add(order2);	
	    	
	        customerRequest.setfirstName("Jai");
	        customerRequest.setlastName("Damm");	        
	        customerRequest.setbillingAddress(billingAddress);
	        customerRequest.setshippingAddress(shippingAddress);
	        customerRequest.setOrders(orders);
	        
	     	String responsePost =  postClient.post(customerRequest, String.class);
	        System.out.println("POST MEDTHOD Response ........." + responsePost);
	        
	        /*****************************************************************************************
	         * GET METHOD invoke for all employees
	         *****************************************************************************************/
	        System.out.println("GET METHOD for all customers..........................................");
	        WebClient getAllClient = WebClient.create("http://localhost:8080", providers);
	        WebClient.getConfig(getAllClient).getOutInterceptors().add(new LoggingOutInterceptor());
	        WebClient.getConfig(getAllClient).getInInterceptors().add(new LoggingInInterceptor());
	        
	        getAllClient = getAllClient.accept("application/json").type("application/json").path("/customerservice/customer");
	                 
	        String getAllRequestURI = getAllClient.getCurrentURI().toString();
	        System.out.println("Client GET METHOD Request URI:  " + getAllRequestURI);
	        String getAllRequestHeaders = getAllClient.getHeaders().toString();
	        System.out.println("Client GET METHOD Request Headers:  " + getAllRequestHeaders);
	        
	        //to see as raw XML/json
	        String getAllResponse = getAllClient.get(String.class);
	        System.out.println("GET All METHOD Response: ...." + getAllResponse);
	        
	        /*****************************************************************************************
	         * DELETE METHOD invoke
	        *****************************************************************************************/
	        System.out.println("DELETE METHOD .........................................................");
	        WebClient deleteClient = WebClient.create("http://localhost:8080", providers);
	        WebClient.getConfig(deleteClient).getOutInterceptors().add(new LoggingOutInterceptor());
	        WebClient.getConfig(deleteClient).getInInterceptors().add(new LoggingInInterceptor());
	        
	        deleteClient = deleteClient.accept("application/xml").type("application/json").path("/customerservice/customer/XY1111");
	     	
	        String deleteRequestURI = deleteClient.getCurrentURI().toString();
	        System.out.println("Client DELETE METHOD Request URI:  " + deleteRequestURI);
	        String deleteRequestHeaders = deleteClient.getHeaders().toString();
	        System.out.println("Client DELETE METHOD Request Headers:  " + deleteRequestHeaders);
	        
	        deleteClient.delete();
	        System.out.println("DELETE MEDTHOD Response ......... OK");
	         
	        System.exit(0);
			
	}
}
