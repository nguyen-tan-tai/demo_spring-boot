package com.example.demo.controllers.order.place;

import com.example.demo.controllers.BaseController;
import com.example.demo.controllers.order.OrderResponse;
import com.example.demo.models.entities.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceOrderRequestController extends BaseController {

    @PostMapping("/orders")
    public ResponseEntity<?> get(PlaceOrderRequest request) {
        return ok(new OrderResponse(new Order()));
    }
}
