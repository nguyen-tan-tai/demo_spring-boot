package com.example.demo.models.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.models.entities.Order;
import com.example.demo.models.entities.Order.ORDER_STATUS;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
class OrderRepositoryTest {
    @Autowired
    OrderRepository orderRepository;

    @Test
    @Sql(value = {
            "OrderRepositoryTest/testInsert/orders.sql",
    })
    void testInsert() {
        Order order = orderRepository.insert(1000L, ORDER_STATUS.RECEIVED, OffsetDateTime.of(1, 2, 3, 4, 5, 0, 0, ZoneOffset.UTC));
        assertThat(order.getOrdId()).isEqualTo(102000010L);
    }
}
