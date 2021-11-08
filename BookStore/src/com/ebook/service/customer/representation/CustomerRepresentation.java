package com.ebook.service.customer.representation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ebook.model.customer.Address;
import com.ebook.model.order.Order;

@XmlRootElement(name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class CustomerRepresentation {
	
	private String customerId;
	private String lastName;
	private String firstName;
	private Address billingAddress;
	private Address shippingAddress;
	private List<Order> orders = new ArrayList<Order>();

	public CustomerRepresentation() {}
	
	public String getcustomerId() {
		return customerId;
	}
	
	public void setcustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getfirstName() {
		return firstName;
	}
	
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Address getbillingAddress() {
		return billingAddress;
	}
	
	public void setbillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	public Address getshippingAddress() {
		return shippingAddress;
	}
	
	public void setshippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}


}
