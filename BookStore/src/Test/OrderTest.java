package com.ebook.model.orderTest;


import static org.junit.Assert.*;

import org.junit.Test;

import com.ebook.model.item.Product;
import com.ebook.model.order.Order;

public class OrderTest {

	public Product getProduct() {
		
		Product pro1 = new Product();
		pro1.setId("test");
		pro1.setTitle("testtitle");
		pro1.setPrice(99.00);
		return pro1;
		
	}
	
	@Test
	public final void testAddProduct() {
	
		Order obj1 = new Order();
		Product pro1 = getProduct();
		obj1.setOrderState("Open");
		obj1.addProduct(pro1, 1);

		Product expectedProd = obj1.getOrderDetails().get(0).getProduct();
		
		assertEquals(expectedProd.getId(), pro1.getId());
		assertEquals(String.valueOf(expectedProd.getPrice()), String.valueOf(pro1.getPrice()));
		assertEquals(expectedProd.getTitle(), pro1.getTitle());
		
	}
	
	@Test(expected = IllegalStateException.class)
	public final void testAddProductException(){
		Order obj1 = new Order();
		Product pro1 = getProduct();
		obj1.setOrderState("Close");
		obj1.addProduct(pro1, 1);
	}

	@Test
	public final void testCancelOrder() {
		Order obj1 = new Order();
		obj1.setOrderState("Open");
		obj1.cancelOrder();

		assertEquals("Canceled", obj1.getOrderState());
	}

	@Test
	public final void testConfirmOrderCancel() {
		Order obj1 = new Order();
		obj1.getOrderDetails().isEmpty();
		obj1.confirmOrder();
		assertEquals("Canceled", obj1.getOrderState());
	}
	@Test
	public final void testConfirmOrderOrdered() {
		Order obj1 = new Order();
		Product pro1 = getProduct();
		obj1.setOrderState("Open");
		obj1.addProduct(pro1, 1);
		obj1.confirmOrder();
		assertEquals("Ordered", obj1.getOrderState());
	}
	@Test(expected = IllegalStateException.class)
	public final void testConfirmOrderException() {
		Order obj1 = new Order();
		Product pro1 = getProduct();
		obj1.setOrderState("Delivered");
		obj1.addProduct(pro1, 1);
		obj1.confirmOrder();	
	}

	@Test
	public final void testOrderDelivered() {
		Order obj1 = new Order();
		obj1.setOrderState("Shipped");
		obj1.orderDelivered();
		assertEquals("Delivered",obj1.getOrderState());
	}
	
	@Test(expected = IllegalStateException.class)
	public final void testOrderDeliveredException() {
		Order obj1 = new Order();
		obj1.setOrderState("Canceled");
		obj1.orderDelivered();
	}

	@Test
	public final void testOrderPayed() {
		Order obj1 = new Order();
		obj1.setOrderState("Ordered");
		obj1.orderPayed();
		assertEquals(true, obj1.isPaymentReceived());
		
	}

	@Test
	public final void testOrderSendOut() {
		Order obj1 = new Order();
		obj1.setOrderState("Ordered");
		obj1.setPaymentReceived(true);
		obj1.orderSendOut();
		assertEquals("Shipped", obj1.getOrderState());
	}

}
