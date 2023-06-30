package com.externshipproject.FoodOrderingSystemTeam110.rest_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.externshipproject.FoodOrderingSystemTeam110.model.FoodItem;
import com.externshipproject.FoodOrderingSystemTeam110.model.Restaurant;
import com.externshipproject.FoodOrderingSystemTeam110.service.RestaurantService;

@RestController
@RequestMapping("restaurants")
public class RestaurantController {

	@Autowired
    private RestaurantService restaurantService;

//    public RestaurantController(RestaurantService restaurantService) {
//        this.restaurantService = restaurantService;
//    }

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurants(@RequestParam("query") String query) {
        List<Restaurant> matchingRestaurants = restaurantService.searchRestaurants(query);
        return ResponseEntity.ok(matchingRestaurants);
    }
    @GetMapping("/{id}/fooditems")
    public ResponseEntity<List<FoodItem>> getFoodItemsByRestaurantId(@PathVariable("id") Long restaurantId) {
        List<FoodItem> foodItems = restaurantService.getFoodItemsByRestaurantId(restaurantId);
        return ResponseEntity.ok(foodItems);
    }
}
