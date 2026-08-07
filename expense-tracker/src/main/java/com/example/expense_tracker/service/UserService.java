package com.example.expense_tracker.service;

import com.example.expense_tracker.model.User;
import com.example.expense_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Tells Spring Boot this class handles our business logic
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method to create a user
    public User createUser(User user) {
        // Later, we can add logic here to check if the email already exists!
        return userRepository.save(user);
    }

    // Method to get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}