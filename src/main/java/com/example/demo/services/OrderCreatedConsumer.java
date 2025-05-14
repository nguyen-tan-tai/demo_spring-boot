package com.example.demo.services;

import org.springframework.stereotype.Component;

@Component
public class OrderCreatedConsumer {

    public void handleOrder(Long orderId) {
        System.out.println(orderId);
    }
}
