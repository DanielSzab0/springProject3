package com.example.springproject3.repository;

import com.example.springproject3.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

//    Optional<Product> findProductByNameAndPriceAndQuantity(String name, Double price, Integer quantity);
//    Product getProductByNameAndPrice(String name, Double price);
//    Product save(Product product);
}
