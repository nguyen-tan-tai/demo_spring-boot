package com.example.demo.models.repositories;

import com.example.demo.models.entities.OrderItem;
import java.time.OffsetDateTime;

public interface OrderItemRepository extends BaseRepository<OrderItem, Long> {

    default OrderItem insert(Long orderId, Long prdId, String prdName, Integer quantity, String price, OffsetDateTime createdAt) {
        OrderItem o = new OrderItem();
        o.setOrderId(orderId);
        o.setPrdId(prdId);
        o.setPrdName(prdName);
        o.setQuantity(quantity);
        o.setPrice(price);
        o.setCreatedAt(createdAt);
        this.save(o);
        return o;
    }
}
