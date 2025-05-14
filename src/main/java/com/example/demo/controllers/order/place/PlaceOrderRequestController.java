package com.example.demo.controllers.order.place;

import com.example.demo.controllers.BaseController;
import com.example.demo.services.OrderCreationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceOrderRequestController extends BaseController {

    @Autowired
    OrderCreationService orderCreationService;

    @PostMapping("/order")
    public ResponseEntity<?> get(@Valid @RequestBody PlaceOrderRequest request) {
        Long customerId = 101000001L;
        Long orderId = orderCreationService.create(customerId, request.getItemsAsOrderItems());
        return ok(new PlaceOrderResponse(orderId));
    }
}
