package com.example.expense_tracker.service;

import com.example.expense_tracker.exception.ResourceNotFoundException;
import com.example.expense_tracker.model.Category;
import com.example.expense_tracker.model.Transaction;
import com.example.expense_tracker.model.User;
import com.example.expense_tracker.repository.CategoryRepository;
import com.example.expense_tracker.repository.TransactionRepository;
import com.example.expense_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Transaction createTransaction(Transaction transaction, Long userId, Long categoryId) {
        // 1. Find the user, or throw our custom error!
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        // 2. Find the category, or throw our custom error!
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));

        // 3. Attach them to the transaction
        transaction.setUser(user);
        transaction.setCategory(category);

        // 4. Save to the database
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByUser(Long userId) {
        return transactionRepository.findByUserId(userId);
    }
    public void deleteTransaction(Long transactionId) {
        // This is a built-in method that automatically deletes the row from Neon!
        transactionRepository.deleteById(transactionId); 
    }
}
