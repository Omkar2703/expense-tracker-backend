package com.example.expense_tracker.model;

import jakarta.persistence.*;

@Entity // Tells Hibernate to make a table out of this class
@Table(name = "categories") // Optional: names the table "categories" instead of "category"
public class Category {

    @Id // This is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID
    private Long id;

    @Column(nullable = false, unique = true) // Cannot be null, must be unique
    private String name;

    @Enumerated(EnumType.STRING) // Saves "INCOME" or "EXPENSE" as text in DB
    @Column(nullable = false)
    private CategoryType type;

    // You MUST generate Getters and Setters for all fields!

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    // In IntelliJ: Right-click -> Generate -> Getter and Setter -> Select all
}