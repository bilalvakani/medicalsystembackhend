package com.example.authapp.service;

import com.example.authapp.model.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserService userService;

    public LoginService(UserService userService) {
        this.userService = userService;
    }

    public boolean authenticateUser(String username, String password) {
        for (User u : userService.getUsers()) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
