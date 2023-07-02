package com.externshipproject.FoodOrderingSystemTeam110.controller;

import com.externshipproject.FoodOrderingSystemTeam110.model.FoodItem;
import com.externshipproject.FoodOrderingSystemTeam110.model.Restaurant;
import com.externshipproject.FoodOrderingSystemTeam110.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	@Autowired
    private RestaurantService restaurantService;
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
    @GetMapping("/{id}")
    public String getRestaurant(@PathVariable("id") Long id,Model model) {

        Restaurant restaurant = restaurantService.getRestaurantById(id);

        model.addAttribute("restaurant", restaurant);
        model.addAttribute("restaurantId",restaurant.getId());

        return "restaurant";
    }


}