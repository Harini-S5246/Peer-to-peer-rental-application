package com.rentalplatform.backend.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rentalplatform.backend.entity.User;
import com.rentalplatform.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repo;
    
    public User getUser(UUID id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
    
}
