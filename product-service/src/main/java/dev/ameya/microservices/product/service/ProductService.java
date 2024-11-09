package dev.ameya.microservices.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ameya.microservices.product.dto.ProductRequest;
import dev.ameya.microservices.product.dto.ProductResponse;
import dev.ameya.microservices.product.model.Product;
import dev.ameya.microservices.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {

        Product product = Product.builder()
        .name(productRequest.name())
        .description(productRequest.description())
        .price(productRequest.price())
        .build();
        
        productRepository.save(product);
        
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getProducts() {
        return productRepository.findAll()
        .stream()
        .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
        .toList();
    }

}
