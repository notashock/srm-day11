package com.example.day11.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {

        return org.springframework.security.core.userdetails.User.builder()
                .username(username)
                .password("{noop}password")
                .roles("USER")
                .build();
    }
}
