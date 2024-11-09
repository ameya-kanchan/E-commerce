package dev.ameya.microservices.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ameya.microservices.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);

}
