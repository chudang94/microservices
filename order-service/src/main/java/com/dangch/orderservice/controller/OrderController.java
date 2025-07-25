package com.dangch.orderservice.controller;

import com.dangch.orderservice.dto.OrderRequest;
import com.dangch.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        System.out.println("Received order request: " + orderRequest);
        orderService.placeOrder(orderRequest);
        return "Order placed successfully";
    }
}
