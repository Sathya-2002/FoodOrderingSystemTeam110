package com.externshipproject.FoodOrderingSystemTeam110.service;

import com.externshipproject.FoodOrderingSystemTeam110.model.LoginRequest;
import com.externshipproject.FoodOrderingSystemTeam110.model.RegisterUserRequest;
import com.externshipproject.FoodOrderingSystemTeam110.model.User;
import com.externshipproject.FoodOrderingSystemTeam110.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User registerUser(RegisterUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        return userRepository.save(user);
    }
    public User loginUser(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        User user = userRepository.findByUsername(username);
        if (user == null || !password.equals( user.getPassword())) throw new RuntimeException("Invalid username or password");
        return user;
    }
}