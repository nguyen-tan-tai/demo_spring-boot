package com.example.demo.controllers.order.list;

import com.example.demo.controllers.BaseListResponse;
import com.example.demo.controllers.order.OrderResponse;
import com.example.demo.models.entities.Order;
import org.springframework.data.domain.Page;

public class OrderListResponse extends BaseListResponse<OrderResponse> {

    private static final long serialVersionUID = 1L;

    public OrderListResponse(Page<Order> orders) {
        for (Order o : orders) {
            this.add(new OrderResponse(o));
        }
    }
}
