package com.example.expense_tracker.exception;

// RuntimeException means our app can throw this error while it's running
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}