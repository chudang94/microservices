package com.dangch.orderservice.service;

import com.dangch.orderservice.dto.OrderRequest;
import com.dangch.orderservice.model.Order;
import com.dangch.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        // Logic to place an order
        // This could involve saving the order to the database using OrderRepository
        // and possibly interacting with other services (e.g., inventory, payment)

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setSkuCode(orderRequest.skuCode());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        // Save the order to the database
        orderRepository.save(order);

    }
}
