package com.dangch.orderservice.service;

import com.dangch.orderservice.client.InventoryClient;
import com.dangch.orderservice.dto.OrderRequest;
import com.dangch.orderservice.model.Order;
import com.dangch.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {

        System.out.println("Placing order for SKU: " + orderRequest.skuCode() +
                ", Quantity: " + orderRequest.quantity() +
                ", Price: " + orderRequest.price());
        var isInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if(isInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setSkuCode(orderRequest.skuCode());
            order.setPrice(orderRequest.price());
            order.setQuantity(orderRequest.quantity());
            // Save the order to the database
            orderRepository.save(order);
        }   else {
            throw new RuntimeException("Product is not in stock: " + orderRequest.skuCode());
        }

    }


    public List<Order> getAllOrders(){
        List<Order> orders = orderRepository.findAll();

        return orders;
    }

}
