package com.example.demo.services;

import com.example.demo.configs.RabbitMQConfig;
import com.example.demo.models.entities.Order;
import com.example.demo.models.entities.Order.ORDER_STATUS;
import com.example.demo.models.entities.OrderItem;
import com.example.demo.models.repositories.OrderItemRepository;
import com.example.demo.models.repositories.OrderRepository;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCreationService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    public Long create(Long customerId, List<OrderItem> orderItems) {
        OffsetDateTime processDateTime = OffsetDateTime.now();
        Order order = new Order();
        order.setCustId(customerId);
        order.setStatus(ORDER_STATUS.RECEIVED);
        order.setCreatedAt(processDateTime);
        orderRepository.save(order);
        for (OrderItem o : orderItems) {
            o.setOrderId(order.getOrdId());
            o.setPrdName("");
            o.setCreatedAt(processDateTime);
            orderItemRepository.save(o);
        }
        rabbitTemplate.convertAndSend(RabbitMQConfig.orderTopicExchangeName, "orders.created", order.getOrdId());
        return order.getOrdId();
    }
}
