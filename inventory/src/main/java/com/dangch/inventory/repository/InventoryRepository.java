package com.dangch.inventory.repository;


import com.dangch.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    boolean existsBySkuCodeAndQuantityGreaterThan(String skuCode, Integer quantity);
}
