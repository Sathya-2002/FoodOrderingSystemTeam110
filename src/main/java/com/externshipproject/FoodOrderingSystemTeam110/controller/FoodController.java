package com.externshipproject.FoodOrderingSystemTeam110.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class FoodController {
    @GetMapping("/items")
    public String showFoodItems() {
        return "food_items";
    }
    @GetMapping("/create_item")
    public String showItem(){
    	return "create_food_item";
    }
}