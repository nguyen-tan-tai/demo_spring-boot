package com.example.demo.controllers.order;

import com.example.demo.controllers.BaseResponse;
import com.example.demo.models.entities.Order;
import com.example.demo.utils.DateTimeUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderResponse extends BaseResponse {

    private Order order;

    public OrderResponse(Order o) {
        this.order = o;
    }

    @JsonProperty(value = "orderId", index = 1)
    public Long getOrderId() {
        return this.order.getOrdId();
    }

    @JsonProperty(value = "createdAt", index = 5)
    public String getCreatedAt() {
        return DateTimeUtils.toIsoOffsetDateTimeString(this.order.getCreatedAt());
    }
}
