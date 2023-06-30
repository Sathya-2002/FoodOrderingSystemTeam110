package com.externshipproject.FoodOrderingSystemTeam110.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.externshipproject.FoodOrderingSystemTeam110.model.OrderItem;
import com.externshipproject.FoodOrderingSystemTeam110.repository.OrderItemRepository;

@Service
public class OrderItemService {
    
    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
