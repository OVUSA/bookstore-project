/*package com.ebook.view;

import java.util.List;

import com.ebook.dal.OrderDAO;
import com.ebook.model.customer.Address;
import com.ebook.model.customer.Customer;
import com.ebook.model.item.Book;
import com.ebook.model.order.IFacade;
import com.ebook.model.order.Order;
import com.ebook.model.order.OrderDetail;
import com.ebook.model.order.OrderFacadeImpl;
import com.ebook.model.order.Payment;

public class BookStoreClient {
			
		public static void main (String args[]) throws Exception {
						
	        Customer customer = new Customer();;
			customer.setFirstName("Michael");
	        customer.setLastName("Gerard");
	        customer.setCustomerId("AY2345");
	        
	        Address billingAddress = new Address();
	        billingAddress.setStreet("500 West Madison St.");
	        billingAddress.setUnit("Suite 1000");
	        billingAddress.setCity("Chicago");
	        billingAddress.setState("IL");
	        billingAddress.setZip("66610");
	        customer.setBillingAddress(billingAddress);

	        //Create order for the customer
	        Order order1 = new Order();
	        order1.setOrderId("BO-66734");

	        //Associate the order with the customer
	        customer.addOrder(order1);
	        
	        //order detail contains products ordered
	        
	        //First product
	        Book product1 = new Book();
	        product1.setId("BF-7898");
	        product1.setISBN("234-89675-27690");
	        product1.setTitle("Patterns of Enterprise Application Architecture");
	        product1.setAuthor("Folwer, Martin");
	        product1.setPrice(50.99);
	        
	        //Add product to order
	        order1.addProduct(product1, 1);
	        
	        //Second product
	        Book product2 = new Book();
	        product2.setId("BF-2345");
	        product2.setISBN("892-12345-93667");
	        product2.setTitle("Web Application Architecture");
	        product2.setAuthor("Shklar, Leon");
	        product2.setPrice(45.99);
	        
	        //Add the products detail to Order
	        order1.addProduct(product2, 1);
	        
	        
	        
	      //Third product
	        Book product3 = new Book();
	        product3.setId("BF-234212");
	        product3.setISBN("892-123445-93667");
	        product3.setTitle("testingar Architecture");
	        product3.setAuthor("gmg, dogecoin");
	        product3.setPrice(155.99);
	        
	        //Add the products detail to Order
	        order1.addProduct(product3, 1);
	        
	        //finish order	        
	        order1.confirmOrder();
	       
	        Payment payment = new Payment();
	        payment.setPaymentId(new Long("1234"));
	        payment.setPaymentStatus("Paid");
	        payment.setPaymentType("CreditCard");
	        payment.setSubTotal(order1.getOrderTotal());
	        
	        order1.setPayment(payment);
	        
	        
	        
	        order1.orderPayed();
	        
//	        //finish order	        
//	        order1.confirmOrder();
//	        order1.orderPayed();
	        
	         
	        IFacade facade = new OrderFacadeImpl();
	        facade.create(order1);
	        Order orderCache = (Order) facade.get(order1.getOrderId());
	        
	        System.out.println("get order or order details: "+orderCache );
	        
	        
	  
	        // NOTE: To cancel the request, un-comment the following line.
	        
	        //order.cancel();
	        
	        // Then, comment out the next 2 lines.
	        order1.orderSendOut();
	        facade.update(order1.getOrderId(), order1.getOrderState());
	        order1.orderDelivered();
	        facade.update(order1.getOrderId(), order1.getOrderState());
	      
	        
	        // Print out an order summary
	        Address billingAdd = customer.getBillingAddress();
	        List<OrderDetail> orderLines = orderCache.getOrderDetails();
	        double orderTotal = orderCache.getOrderTotal();

	        // Format order output
	        System.out.println("\tOrder Id: \t\t" + orderCache.getOrderId() + "\n");
	        System.out.println("\tOrder status: \t\t" + orderCache.getOrderState() + "\n");
	        System.out.println("\tName: \t\t\t" + customer.getFirstName() + " " + customer.getLastName() + "\n");

	        System.out.println("\tBilling Address:\t" + billingAdd.getStreet() + 
	        		"\n\t\t\t\t" + billingAdd.getUnit() + 
	        		"\n\t\t\t\t" + billingAdd.getCity() + ", " + 
	        		billingAdd.getState() + " " + billingAdd.getZip() +
	        		"\n");

	        System.out.println("\tOrder Items: ");
	        for (OrderDetail line : orderLines) {
	        	System.out.println("\t\t\t\t" + line.getProduct().getTitle() + "\t" + 
	        			line.getProduct().getPrice() + " x " + line.getQuantity());
	        }

	        System.out.println("\n\tOrder Total:\t\t" + orderTotal);
	        
	        
	        System.out.println("\n\tPayment ID:\t\t" + orderCache.getPayment().getPaymentId());
	        System.out.println("\n\tPayment Type:\t\t" + orderCache.getPayment().getPaymentType());
	        System.out.println("\n\tPayment Status:\t\t" + orderCache.getPayment().getPaymentStatus());
	        
		}

}*/
