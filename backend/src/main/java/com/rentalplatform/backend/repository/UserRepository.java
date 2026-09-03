package com.rentalplatform.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentalplatform.backend.entity.User;

public interface UserRepository extends JpaRepository<User,UUID> {
    
}
