package com.vcriate.RestaurantManagementSystem.Service;

import java.util.List;

import com.vcriate.RestaurantManagementSystem.Exception.OrderException;
import com.vcriate.RestaurantManagementSystem.Model.Orders;

public interface OrderService {
	
	List<Orders> getAllOrders();
    Orders getOrderById(Long id) throws OrderException;
    Orders createOrder(Orders order);
    Orders updateOrder(Long id, Orders order) throws OrderException;
    void deleteOrder(Long id) throws OrderException;

}
