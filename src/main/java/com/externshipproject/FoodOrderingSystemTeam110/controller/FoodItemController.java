package com.externshipproject.FoodOrderingSystemTeam110.controller;
import java.util.List;
import java.util.Optional;

import com.externshipproject.FoodOrderingSystemTeam110.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.externshipproject.FoodOrderingSystemTeam110.model.FoodItem;
import com.externshipproject.FoodOrderingSystemTeam110.service.FoodItemService;

@RestController
@RequestMapping("/fooditems")
public class FoodItemController { 

	@Autowired
    private FoodItemService foodItemService;
    @GetMapping
    public ResponseEntity<List<FoodItem>> getAllFoodItems() {
        List<FoodItem> foodItems = foodItemService.getAllFoodItems();
        return ResponseEntity.ok(foodItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable Long id) {
        Optional<FoodItem> foodItem = foodItemService.getFoodItemById(id);
        return ResponseEntity.ok(foodItem.get());
    }
    @GetMapping("/byname")
    public ResponseEntity<List<FoodItem>> getFoodItemsByName(@RequestParam String name) {
    	name = name.toLowerCase();
        List<FoodItem> foodItems = foodItemService.getFoodItemsByName(name);
        return ResponseEntity.ok(foodItems);
    }
    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurantsByFoodItemId(@RequestParam Long foodItemId) {
        FoodItem foodItem = foodItemService.findFoodItemById(foodItemId);

        return foodItem.getRestaurants();
    }

    @PostMapping("/create")
    public ResponseEntity<FoodItem> createFoodItem(@RequestBody FoodItem foodItem) {
    	foodItem.setName(foodItem.getName().toLowerCase());
        FoodItem createdFoodItem = foodItemService.createFoodItem(foodItem);
        return ResponseEntity.ok(createdFoodItem);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deleteFoodItemById(@PathVariable Long id) {
        foodItemService.deleteFoodItemById(id);
        return ResponseEntity.noContent().build();
    }
}