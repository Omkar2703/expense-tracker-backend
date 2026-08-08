package com.example.expense_tracker.controller;

import com.example.expense_tracker.model.User;
import com.example.expense_tracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService; // Changed this from UserRepository to UserService!

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> getAllUsers() {
        // Now we call the service method
        return userService.getAllUsers();
    }
    // Add this to handle the login request from the desktop app
    @GetMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String username) {
        User user = userService.findByUsername(username);
        
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK); // User found!
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // User does not exist
        }
    }
}
