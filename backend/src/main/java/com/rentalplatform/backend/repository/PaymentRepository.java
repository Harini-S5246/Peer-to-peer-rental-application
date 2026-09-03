package com.rentalplatform.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentalplatform.backend.entity.Payment;
import java.util.List;


public interface PaymentRepository extends JpaRepository<Payment, Long>{
    List<Payment> findByBookingId(Long bookingId);
}
