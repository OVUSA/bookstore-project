package com.ebook.service.workflow;

import java.util.ArrayList;
import java.util.List;

import com.ebook.dal.OrderDAO;
import com.ebook.model.order.Order;
import com.ebook.service.representation.OrderRepresentation;
import com.ebook.service.representation.OrderRequest;


public class OrderActivity {
	
	OrderDAO orderdao = new OrderDAO();
    
    
	public OrderRepresentation getOrder(String orderId) {
		
		Order order =  orderdao.getOrder(orderId);
		OrderRepresentation orderRep = new OrderRepresentation();
		
		orderRep.setOrderId(order.getOrderId());
		orderRep.setOrderDetails(order.getOrderDetails());
		orderRep.setOrderState(order.getOrderState());
		orderRep.setPayment(order.getPayment());
		orderRep.setPaymentReceived(order.isPaymentReceived());
		return orderRep;
		
	}
	
	public List<OrderRepresentation> getAllOrders() {
		
		List<OrderRepresentation> orderRepList = new ArrayList<OrderRepresentation>();
		List<Order> orders =  orderdao.getAllOrders();
		for(Order order:orders) {
			OrderRepresentation orderRep = new OrderRepresentation();
			
			
			orderRep.setOrderId(order.getOrderId());
			orderRep.setOrderDetails(order.getOrderDetails());
			orderRep.setOrderState(order.getOrderState());
			orderRep.setPayment(order.getPayment());
			orderRep.setPaymentReceived(order.isPaymentReceived());	
			orderRepList.add(orderRep);
		}
		
		return orderRepList;
		
	}
	
	public OrderRepresentation createOrder(OrderRequest orderReq) {
		
		Order order = new Order();
		order.setOrderState(orderReq.getOrderState());
		order.setOrderDetails(orderReq.getOrderDetails());
		order.setPayment(orderReq.getPayment());
		order.setPaymentReceived(orderReq.isPaymentReceived());
		
		
		
		Order order1 = orderdao.createOrder(order);
		
		OrderRepresentation orderRep = new OrderRepresentation();
		
		orderRep.setOrderId(order1.getOrderId());
		orderRep.setOrderDetails(order1.getOrderDetails());
		orderRep.setOrderState(order1.getOrderState());
		orderRep.setPayment(order1.getPayment());
		orderRep.setPaymentReceived(order1.isPaymentReceived());
		return orderRep;
	
	}
	
	public OrderRepresentation updateOrderstatus(String orderId, String Status) {
		
		Order order = orderdao.updateOrderstatus(orderId, Status);
		
		OrderRepresentation orderRep = new OrderRepresentation();
		
		orderRep.setOrderId(order.getOrderId());
		orderRep.setOrderDetails(order.getOrderDetails());
		orderRep.setOrderState(order.getOrderState());
		orderRep.setPayment(order.getPayment());
		orderRep.setPaymentReceived(order.isPaymentReceived());
		return orderRep;
		
	}


}
