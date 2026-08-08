package com.example.expense_tracker.controller;

import com.example.expense_tracker.model.Transaction;
import com.example.expense_tracker.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // We pass userId and categoryId in the URL parameters
    @PostMapping
    public ResponseEntity<Transaction> addTransaction(
            @Valid @RequestBody Transaction transaction,
            @RequestParam Long userId,
            @RequestParam Long categoryId) {

        Transaction savedTransaction = transactionService.createTransaction(transaction, userId, categoryId);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public List<Transaction> getUserTransactions(@PathVariable Long userId) {
        return transactionService.getTransactionsByUser(userId);
    }
    @DeleteMapping("/{transactionId}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long transactionId) {
        transactionService.deleteTransaction(transactionId);
        return ResponseEntity.noContent().build(); // Returns a 204 success status
    }
}
