package com.example.authapp.service;

import com.example.authapp.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

    public boolean registerUser(User user) {
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())) {
                return false; // User already exists
            }
        }
        users.add(user);
        return true;
    }

    public List<User> getUsers() {
        return users;
    }
}
