package com.externshipproject.FoodOrderingSystemTeam110.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String home(){return "home";}
    @GetMapping("/items")
    public String showFoodItems() {
        return "food_items";
    }

    @GetMapping("/create_item")
    public String showItem(){
    	return "create_food_item";
    }
    @GetMapping("/restaurants")
    public String homeRestaurant(){
        return "restaurants";
    }
    @GetMapping("/restaurant")
    private String showItemsInRestaurant(){
        return "restaurant";
    }
    @GetMapping("/order")
    private String orderPage(){
        return "order_page";
    }
}