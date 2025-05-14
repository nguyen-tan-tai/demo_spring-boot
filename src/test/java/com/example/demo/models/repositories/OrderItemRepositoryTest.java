package com.example.demo.models.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.models.entities.OrderItem;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
class OrderItemRepositoryTest {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Test
    @Sql(value = { "OrderItemRepositoryTest/testInsert/order_items.sql" })
    void testInsert() {
        OrderItem orderItem = orderItemRepository.insert(102000010L, 104000050L, "Costume Amin", 100, "10.5", OffsetDateTime.of(1, 2, 3, 4, 5, 0, 0, ZoneOffset.UTC));
        assertThat(orderItem.getOrderItemId()).isEqualTo(103000010L);
    }
}
