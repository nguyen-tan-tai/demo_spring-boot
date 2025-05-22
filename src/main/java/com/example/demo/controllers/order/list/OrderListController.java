package com.example.demo.controllers.order.list;

import com.example.demo.controllers.BaseController;
import com.example.demo.models.entities.Order;
import com.example.demo.models.repositories.OrderRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Order Management", description = "Order related to catalog")
public class OrderListController extends BaseController {

    @Autowired
    private OrderRepository orderRepository;

    @Operation(summary = "List orders")
    @ApiResponse(responseCode = "200", description = "OK", content = {@Content(schema = @Schema(implementation = OrderListResponse.class))})
    @GetMapping("/orders")
    public ResponseEntity<?> get() {
        Page<Order> orders = orderRepository.findAll(Pageable.ofSize(100));
        return ok(new OrderListResponse(orders));
    }
}
