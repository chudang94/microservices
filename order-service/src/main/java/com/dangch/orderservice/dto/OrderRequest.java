package com.dangch.orderservice.dto;

import java.math.BigDecimal;

public record OrderRequest(String id, String orderNumber, String skuCode, BigDecimal price, Integer quantity, UserDetails userDetails) {
    // This record class is used to encapsulate the order request data
    // It includes fields for order ID, order number, SKU code, price, and quantity
    // The record automatically generates getters and a constructor
    public record UserDetails(String email, String firstName, String lastName){}
}
