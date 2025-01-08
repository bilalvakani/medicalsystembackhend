package com.example.authapp.controller;
import java.util.Map;
import java.util.HashMap;


import com.example.authapp.model.User;
import com.example.authapp.service.LoginService;
import com.example.authapp.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            return "UserHH registered successfully!";
        } else {
            return "User already exists!";
        }
    }

    
    @PostMapping("/login")
public ResponseEntity<Map<String, String>> loginUser(@RequestParam String username, @RequestParam String password) {
    boolean isAuthenticated = loginService.authenticateUser(username, password);
    Map<String, String> response = new HashMap<>();
    
    if (isAuthenticated) {
        response.put("message", "Login successful!");
        return ResponseEntity.ok(response); // Return success with 200 OK
    } else {
        response.put("message", "Invalid credentials!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); // Return error with 400 BAD REQUEST
    }
}

}
