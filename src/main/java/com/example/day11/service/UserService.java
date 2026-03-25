package com.example.day11.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.day11.model.User;
import com.example.day11.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User createUser(String email, String password) {
        User user = new User(email, password);
        return repository.save(user);
    }

    public void deleteUser(int id) {
        repository.deleteById(id);
    }

    public User updateUser(int id, User user) {
        user.setId(id);
        return repository.save(user);
    }
}
