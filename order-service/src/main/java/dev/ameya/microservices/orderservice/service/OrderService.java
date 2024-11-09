package dev.ameya.microservices.orderservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ameya.microservices.orderservice.client.InventoryClient;
import dev.ameya.microservices.orderservice.dto.OrderRequest;
import dev.ameya.microservices.orderservice.model.Order;
import dev.ameya.microservices.orderservice.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryClient inventoryClient;

    public String placeOrder(OrderRequest orderRequest) {

        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if(isProductInStock) {
            Order order = Order.builder()
            .orderNumber(UUID.randomUUID().toString())
            .skuCode(orderRequest.skuCode())
            .price(orderRequest.price())
            .quantity(orderRequest.quantity())
            .build();   
    
            orderRepository.save(order);
            return "Order Placed Successfully";
        }   else {
            return "Product with skuCode "+orderRequest.skuCode()+" is not in stock";
        }
        

        
    }
}
