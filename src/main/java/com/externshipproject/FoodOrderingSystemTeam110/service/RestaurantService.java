package com.externshipproject.FoodOrderingSystemTeam110.service;

import java.util.List;
import java.util.Optional;

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
        
		List<FoodItem> foodItems = foodItemRepository.findByRestaurantsId(restaurantId);
        if (foodItems.isEmpty()) {
            throw new RuntimeException("No food items found for the restaurant with ID: " + restaurantId);
        }
        return foodItems;
    }
    public Restaurant getRestaurantById(Long id){
        Optional<Restaurant> optionalRestaurant= restaurantRepository.findById(id);
        return optionalRestaurant.get();
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public boolean deleteRestaurant(Long restaurantId) {
        try {
            restaurantRepository.deleteById(restaurantId);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public void addRestaurant(Restaurant restaurant){
        restaurantRepository.save(restaurant);
    }
}