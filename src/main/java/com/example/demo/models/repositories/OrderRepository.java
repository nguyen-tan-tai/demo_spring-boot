package com.example.demo.models.repositories;

import com.example.demo.models.entities.Order;
import com.example.demo.models.entities.Order.ORDER_STATUS;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public interface OrderRepository extends BaseRepository<Order, Long> {

    default Order insert(long customerId, ORDER_STATUS status, OffsetDateTime createdTime) {
        Order order = new Order();
        order.setCustId(1000L);
        order.setStatus(ORDER_STATUS.RECEIVED);
        order.setCreatedAt(OffsetDateTime.of(1, 2, 3, 4, 5, 0, 0, ZoneOffset.UTC));
        this.save(order);
        return order;
    }
}
