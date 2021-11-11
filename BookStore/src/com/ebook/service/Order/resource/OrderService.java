package com.ebook.service.Order.resource;


import java.util.List;

import javax.jws.WebService;

import com.ebook.service.Order.representation.OrderRepresentation;
import com.ebook.service.Order.representation.OrderRequest;
import com.ebook.service.Order.representation.OrderUpdateRequest;

@WebService

public interface OrderService {

    OrderRepresentation updateOrder(OrderUpdateRequest orderUpdateReq);
    OrderRepresentation getOrder(String orderId);
    OrderRepresentation createOrder(OrderRequest orderRequest);
    List<OrderRepresentation> getAllOrders();

    //public Response updateEmployee(EmployeeRequest employeeRequest);
    //public Response deleteEmployee(String employeeId);
}
