package com.example.springproject3.service;

import com.example.springproject3.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService { //aici ne vom declara ceea ce vrem sa faca aplicatia noastr

    void saveProduct(Product product);
    List<Product> getAllProduct();
    void editProduct(Integer id, Product product);
    Product getProductById(Integer id);
    void deleteProductById(Integer id);
}
