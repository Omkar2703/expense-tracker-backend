package com.example.expense_tracker.repository;

import com.example.expense_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository gives us save(), findAll(), findById(), deleteById() for free!
    User findByUsername(String username);
}
