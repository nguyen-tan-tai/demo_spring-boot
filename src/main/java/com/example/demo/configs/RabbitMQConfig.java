package com.example.demo.configs;

import com.example.demo.services.OrderCreatedConsumer;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String orderTopicExchangeName = "order-events-exchange";

    public static final String orderQueueName = "order-events";

    @Bean
    Queue newOrderQueue() {
        return new Queue(orderQueueName, false);
    }

    @Bean
    TopicExchange newOrderExchange() {
        return new TopicExchange(orderTopicExchangeName);
    }

    @Bean
    Binding binding(Queue newOrderQueue, TopicExchange newOrderExchange) {
        return BindingBuilder.bind(newOrderQueue).to(newOrderExchange).with("orders.#");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(orderQueueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(OrderCreatedConsumer orderCreatedConsumer) {
        return new MessageListenerAdapter(orderCreatedConsumer, "handleOrder");
    }
}
