package com.example.expense_tracker.repository;

import com.example.expense_tracker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // We can define custom query methods just by naming them correctly!
    List<Transaction> findByUserId(Long userId);
}