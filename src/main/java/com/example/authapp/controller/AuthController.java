package com.example.authapp.controller;

import com.example.authapp.model.User;
import com.example.authapp.service.LoginService;
import com.example.authapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        boolean isRegistered = userService.registerUser(user);
        if (isRegistered) {
            return "User registered successfully!";
        } else {
            return "User already exists!";
        }
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        boolean isAuthenticated = loginService.authenticateUser(username, password);
        if (isAuthenticated) {
            return "Login successful!";
        } else {
            return "Invalid credentials!";
        }
    }
}
