package com.example.demo.controllers.order.place;

import com.example.demo.controllers.BaseController;
import com.example.demo.services.OrderCreationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Order Management", description = "Order related to catalog")
public class PlaceOrderRequestController extends BaseController {

    @Autowired
    OrderCreationService orderCreationService;

    @Operation(summary = "Place order")
    @ApiResponse(responseCode = "200", description = "OK", content = {@Content(schema = @Schema(implementation = PlaceOrderResponse.class))})
    @PostMapping("/order")
    public ResponseEntity<?> get(@Valid @RequestBody PlaceOrderRequest request) {
        Long customerId = 101000001L;
        Long orderId = orderCreationService.create(customerId, request.getItemsAsOrderItems());
        return ok(new PlaceOrderResponse(orderId));
    }
}
