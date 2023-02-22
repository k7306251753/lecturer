package com.lectures.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lectures.demo.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
