package com.dangch.orderservice.repository;

import com.dangch.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Additional query methods can be defined here if needed
    // For example, to find orders by skuCode:
    // List<Order> findBySkuCode(String skuCode);
}
