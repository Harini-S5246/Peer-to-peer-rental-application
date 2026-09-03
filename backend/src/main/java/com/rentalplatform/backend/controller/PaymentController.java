package com.rentalplatform.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalplatform.backend.entity.Payment;
import com.rentalplatform.backend.service.PaymentService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;
    @PostMapping
    public Payment postMethodName(@RequestBody Payment payment) {
        
        return service.create(payment);
    }

    @GetMapping("/booking/{bookingId}")
    public List<Payment> getBooking(@PathVariable Long bookingId) {
        return service.getByBooking(bookingId);
    }
    
    
}
