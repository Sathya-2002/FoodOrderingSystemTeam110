package com.externshipproject.FoodOrderingSystemTeam110.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.externshipproject.FoodOrderingSystemTeam110.model.FoodItem;
import com.externshipproject.FoodOrderingSystemTeam110.model.Restaurant;
import com.externshipproject.FoodOrderingSystemTeam110.repository.FoodItemRepository;
import com.externshipproject.FoodOrderingSystemTeam110.repository.RestaurantRepository;

@Service
public class RestaurantService {
	@Autowired
    private RestaurantRepository restaurantRepository;
	@Autowired
	private FoodItemRepository foodItemRepository;
    public List<Restaurant> searchRestaurants(String query) {
    	List<Restaurant> restaurants = restaurantRepository.findByName(query);
        return restaurants;
    }    
    public List<FoodItem> getFoodItemsByRestaurantId(Long restaurantId) {
        
		List<FoodItem> foodItems = foodItemRepository.findByRestaurantId(restaurantId);
        if (foodItems.isEmpty()) {
            throw new RuntimeException("No food items found for the restaurant with ID: " + restaurantId);
        }
        return foodItems;
    }
}