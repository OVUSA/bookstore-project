package com.ebook.service;


import com.ebook.service.representation.OrderRepresentation;
import com.ebook.service.representation.OrderRequest;
import com.ebook.service.representation.OrderUpdateRequest;
import com.ebook.service.workflow.OrderActivity;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/orderservice/")
public class OrderResource implements OrderService {
 

    @POST 
    @Produces({"application/xml" , "application/json"})    
    //@Cacheable(cc="public, maxAge=3600") example for caching
    @Path("/order/update")
    public OrderRepresentation updateOrder(OrderUpdateRequest orderUpdateReq) {
        System.out.println("GET METHOD Request for all orders ............."+"----ID:"+orderUpdateReq.getOrderId()+"------Status:"+orderUpdateReq.getStatus());
        OrderActivity orderActivity = new OrderActivity();
        return orderActivity.updateOrderstatus(orderUpdateReq.getOrderId(), orderUpdateReq.getStatus());
    }
    
    @GET 
    @Produces({"application/xml" , "application/json"})    
    //@Cacheable(cc="public, maxAge=3600") example for caching
    @Path("/orders")
	public List<OrderRepresentation> getAllOrders() {
    	 OrderActivity orderActivity = new OrderActivity();
         List<OrderRepresentation> response = orderActivity.getAllOrders();
         return response;
	
	}
    
    @GET 
    @Produces({"application/xml" , "application/json"})    
    //@Cacheable(cc="public, maxAge=3600") example for caching
    @Path("/order/{orderId}")
    public OrderRepresentation getOrder(@PathParam("orderId") String id) {
        System.out.println("GET METHOD Request from Client with orderRequest String ............." + id);
        OrderActivity orderActivity = new OrderActivity();
        OrderRepresentation response = orderActivity.getOrder(id);
        return response;
    }

//    @PostMapping(value = "/order", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    
    
    @POST
    @Produces({"application/xml" , "application/json"})    
    //@Cacheable(cc="public, maxAge=3600") example for caching
    @Path("/order")
    public OrderRepresentation createOrder(OrderRequest orderRequest) {
        System.out.println("POST METHOD Request from Client with ............." + orderRequest.getOrderDetails() );
        OrderActivity orderActivity = new OrderActivity();
        return orderActivity.createOrder(orderRequest);
    }
//    @DeleteMapping(value = "/order/{orderId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//    public ResponseEntity<String> deleteOrder(@PathVariable("orderId") String id) {
//        System.out.println("Delete METHOD Request from Client with orderRequest String ............." + id);
//        String res = orderActivity.deleteOrder(id);
//        if (res.equals("OK")) {
//            return ResponseEntity
//                    .ok()
//                    .body("OK");
//        }
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("An error occurred");
//    }


}