package dev.ameya.microservices.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.ameya.microservices.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
