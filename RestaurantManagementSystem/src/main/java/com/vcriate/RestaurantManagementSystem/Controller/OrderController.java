package com.vcriate.RestaurantManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcriate.RestaurantManagementSystem.Exception.OrderException;
import com.vcriate.RestaurantManagementSystem.Model.Orders;
import com.vcriate.RestaurantManagementSystem.Service.OrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/get")
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orderById/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id) throws OrderException {
        Orders order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/create")
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) {
        Orders createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Long id, @RequestBody Orders order) throws OrderException {
        Orders updatedOrder = orderService.updateOrder(id, order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) throws OrderException {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
