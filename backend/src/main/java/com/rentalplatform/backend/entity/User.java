package com.rentalplatform.backend.entity;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @Column(name="user_id")
    private UUID userId;

    private String name;

    private String mobile;

    private String location;

    private BigDecimal rating;
    
}
