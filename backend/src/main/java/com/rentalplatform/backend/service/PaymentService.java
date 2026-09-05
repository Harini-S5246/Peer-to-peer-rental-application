package com.rentalplatform.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rentalplatform.backend.entity.Payment;
import com.rentalplatform.backend.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository repo;
    public Payment create(Payment payment){
        payment.setPaymentStatus("PENDING");
        return repo.save(payment);
    }

    public List<Payment> getByBooking(Long bookingId){
        return repo.findByBookingId(bookingId);
    }
}
