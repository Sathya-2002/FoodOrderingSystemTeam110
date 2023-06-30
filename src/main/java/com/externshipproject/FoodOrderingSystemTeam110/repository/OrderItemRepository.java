package com.externshipproject.FoodOrderingSystemTeam110.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.externshipproject.FoodOrderingSystemTeam110.model.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
}