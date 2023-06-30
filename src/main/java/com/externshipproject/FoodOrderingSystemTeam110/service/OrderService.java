package com.externshipproject.FoodOrderingSystemTeam110.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.externshipproject.FoodOrderingSystemTeam110.model.Order;
import com.externshipproject.FoodOrderingSystemTeam110.model.OrderItem;
import com.externshipproject.FoodOrderingSystemTeam110.model.User;
import com.externshipproject.FoodOrderingSystemTeam110.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(User user, List<OrderItem> items) {
        Order order = new Order();
        order.setUser(user);
        order.setItems(items);
        order.setOrderDateTime(LocalDateTime.now());
        order.setTotalPrice(calculateTotalPrice(items));
        order.setStatus("Pending");
        return orderRepository.save(order);
    }

    private double calculateTotalPrice(List<OrderItem> items) {
        double totalPrice = 0.0;
        for (OrderItem item : items) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        return totalPrice;
    }
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public void deleteOrderItem(Long orderId, Long itemId) {
        Order order = getOrder(orderId);
        order.getItems().removeIf(item -> item.getId().equals(itemId));
        orderRepository.save(order);
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
