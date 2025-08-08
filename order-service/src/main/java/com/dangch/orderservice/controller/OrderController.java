package com.dangch.orderservice.controller;

import com.dangch.orderservice.dto.OrderRequest;
import com.dangch.orderservice.model.Order;
import com.dangch.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        System.out.println("Received order request: " + orderRequest);
        orderService.placeOrder(orderRequest);
        return "Order placed successfully";
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrders(){

        return orderService.getAllOrders();
    }
}
