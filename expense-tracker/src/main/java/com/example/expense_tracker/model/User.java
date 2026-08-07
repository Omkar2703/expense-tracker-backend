package com.example.expense_tracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email; // Imports the email rule
import jakarta.validation.constraints.NotBlank; // Imports the blank check rule

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required") // Stops empty or space-only names
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email") // Checks for the '@' and domain
    @Column(nullable = false, unique = true)
    private String email;
    // Generate Getters and Setters!

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}