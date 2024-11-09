package dev.ameya.microservices.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ameya.microservices.inventory.model.Inventory;
import dev.ameya.microservices.inventory.repository.InventoryRepository;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory createInventory(Inventory inventory) {
        
        inventoryRepository.save(inventory);
        return inventory;
    }

    public boolean isInStock(String skuCode, Integer quantity) {
        
       return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }


}
