package com.rentalplatform.backend.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="payments")
@Data
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="payment_id")
    private Long paymentId;
    @Column(name="booking_id")
    private Long bookingId;
    private BigDecimal amount;
    private String paymentType;
    private String paymentMethod;
    private String transactionId;
    private String paymentStatus;
}
