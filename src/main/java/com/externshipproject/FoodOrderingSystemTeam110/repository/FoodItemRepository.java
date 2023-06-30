package com.externshipproject.FoodOrderingSystemTeam110.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.externshipproject.FoodOrderingSystemTeam110.model.FoodItem;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
	List<FoodItem> findByName(String name);
    FoodItem save(FoodItem foodItem);
    FoodItem findById(long id);
    void deleteById(long id);
//	List<FoodItem> findByRestaurantId(Long restaurantId);
	List<FoodItem> findByRestaurantId(Long restaurantId);
}