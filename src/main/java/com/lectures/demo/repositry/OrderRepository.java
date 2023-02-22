package com.lectures.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lectures.demo.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
