package com.lectures.demo.service;

import com.lectures.demo.dto.OrderRequest;
import com.lectures.demo.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
