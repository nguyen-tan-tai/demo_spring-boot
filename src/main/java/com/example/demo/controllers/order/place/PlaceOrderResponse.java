package com.example.demo.controllers.order.place;

import com.example.demo.controllers.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaceOrderResponse extends BaseResponse {

    private Long orderId;

    public PlaceOrderResponse(Long orderId) {
        this.orderId = orderId;
    }

    @JsonProperty(value = "orderId", index = 1)
    public Long getOrderId() {
        return this.orderId;
    }
}
