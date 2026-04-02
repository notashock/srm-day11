package com.example.day11.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.day11.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);

    // SQL : SELECT COUNT(*) FROM users;
    @Query("SELECT COUNT(u) FROM User u")
    int countUsers();

    // SQL: SELECT email FROM users;
    @Query("SELECT u.email FROM User u")
    List<String> findAllEmails(Pageable pageable);
}
