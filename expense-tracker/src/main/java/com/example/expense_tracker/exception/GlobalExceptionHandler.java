package com.example.expense_tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Tells Spring Boot to use this class to watch for errors across ALL controllers
public class GlobalExceptionHandler {

    // This tells Spring: "If a validation error happens, send it to this method!"
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {

        // We will store our clean errors in a dictionary (key: field name, value: error message)
        Map<String, String> errors = new HashMap<>();

        // Loop through all the validation errors that failed
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            // Add the field name (e.g., "email") and our custom message to the dictionary
            errors.put(error.getField(), error.getDefaultMessage());
        }

        // Send back our clean dictionary with a 400 Bad Request status
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(ResourceNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}