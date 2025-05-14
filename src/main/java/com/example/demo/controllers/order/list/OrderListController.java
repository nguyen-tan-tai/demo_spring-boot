package com.example.demo.controllers.order.list;

import com.example.demo.controllers.BaseController;
import com.example.demo.models.entities.Order;
import com.example.demo.models.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderListController extends BaseController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    public ResponseEntity<?> get() {
        Page<Order> orders = orderRepository.findAll(Pageable.ofSize(100));
        return ok(new OrderListResponse(orders));
    }
}
