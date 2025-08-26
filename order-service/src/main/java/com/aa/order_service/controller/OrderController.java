package com.aa.order_service.controller;

import com.aa.order_service.dto.OrderRequest;
import com.aa.order_service.dto.OrderResponse;
import com.aa.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    @Value("${custom.message:Default message}")
    private String message;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody OrderRequest request) {
        return ResponseEntity.ok(service.placeOrder(request));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }
}
