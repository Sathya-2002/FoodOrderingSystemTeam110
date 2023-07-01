package com.externshipproject.FoodOrderingSystemTeam110.controller;

import com.externshipproject.FoodOrderingSystemTeam110.model.Restaurant;
import com.externshipproject.FoodOrderingSystemTeam110.model.User;
import com.externshipproject.FoodOrderingSystemTeam110.service.RestaurantService;
import com.externshipproject.FoodOrderingSystemTeam110.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private  UserService userService;

//    public AdminController(UserService userService, RestaurantService restaurantService) {
//        this.userService = userService;
//        this.restaurantService = restaurantService;
//    }

    @GetMapping("/auth")
    private String adminHome(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        User adminUser = userService.loginAdmin(username, password);
        if (adminUser != null&& adminUser.isAdmin() && adminUser.getPassword().equals(password)) {
            return "admin";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "admin_login"; // Redirect back to the login page with an error message
        }
    }
    @GetMapping("/login")
    private String adminLogin(){
        return "admin_login";
    }

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public String showRestaurantList(Model model) {
        List<Restaurant> restaurantList = restaurantService.getAllRestaurants();
        model.addAttribute("restaurants", restaurantList);
        return "admin/restaurant_list";
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable("restaurantId") Long restaurantId) {
        if (restaurantService.deleteRestaurant(restaurantId)) {
            return ResponseEntity.ok("Restaurant deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurant not found.");
        }
    }
}
