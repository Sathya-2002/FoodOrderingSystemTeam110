package com.externshipproject.FoodOrderingSystemTeam110.controller;

import com.externshipproject.FoodOrderingSystemTeam110.model.LoginRequest;
import com.externshipproject.FoodOrderingSystemTeam110.model.RegisterUserRequest;
import com.externshipproject.FoodOrderingSystemTeam110.model.User;
import com.externshipproject.FoodOrderingSystemTeam110.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class WelcomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String welcome() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<String> processLogin(@ModelAttribute("loginRequest") LoginRequest loginRequest, Model model) {
        if (userService.loginUser(loginRequest)!=null) {
            ResponseEntity.ok("success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("error");
        }
        return null;
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("registerUserRequest") RegisterUserRequest registerUserRequest,
                                      Model model) {
        if (userService.registerUser(registerUserRequest) !=null) {
            return "redirect:/login";
        } else {
            model.addAttribute("errorMessage", "Registration failed. Please try again.");
            return "register";
        }
    }

}
