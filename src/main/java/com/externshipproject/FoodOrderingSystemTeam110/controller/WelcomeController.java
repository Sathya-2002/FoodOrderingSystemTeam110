package com.externshipproject.FoodOrderingSystemTeam110.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin() {
        // Logic to process login credentials
        // Redirect to the appropriate page based on login success or failure
        return "login"; // Redirect to the welcome page after successful login
    }

    @GetMapping("/logout")
    public String logout() {
        // Logic to handle user logout
        // Perform any necessary cleanup or session invalidation
        return "/login"; // Redirect to the login page after logout
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration() {
        // Logic to process user registration form submission
        // Perform necessary validation and database operations
        return "/login"; // Redirect to the login page after successful registration
    }

}
