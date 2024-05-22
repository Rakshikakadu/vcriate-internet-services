package com.vcriate.RestaurantManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcriate.RestaurantManagementSystem.Exception.OrderException;
import com.vcriate.RestaurantManagementSystem.Model.Orders;
import com.vcriate.RestaurantManagementSystem.Repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
    private OrderRepository orderRepository;

	@Override
	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Orders getOrderById(Long id) throws OrderException {
		return orderRepository.findById(id)
                .orElseThrow(() -> new OrderException("Order not found with id: " + id));
    
	}

	@Override
	public Orders createOrder(Orders order) {
		return orderRepository.save(order);
	}

	@Override
	public Orders updateOrder(Long id, Orders order) throws OrderException {
		Orders existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderException("Order not found with id: " + id));
        
        existingOrder.setMenuItem(order.getMenuItem());
        existingOrder.setCustomer(order.getCustomer());
        existingOrder.setQuantity(order.getQuantity());
        
        return orderRepository.save(existingOrder);
	}

	@Override
	public void deleteOrder(Long id) throws OrderException {
		Orders existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderException("Order not found with id: " + id));
        
        orderRepository.delete(existingOrder);
		
	}

}
