package com.example.springproject3.service;

import com.example.springproject3.entity.Product;
import com.example.springproject3.exception.ProductNotFoundException;
import com.example.springproject3.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository; //injectez un bean de tip ProductRepo.
                                                        // intr-un bean te tip ProductServiceImpl

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public void editProduct(Integer id, Product product) {
        Product productToBeUpdated = getProductById(id);
        if (productToBeUpdated != null) {
            productToBeUpdated.setName(product.getName());
            if (product.getPrice() != null) {
                productToBeUpdated.setPrice(product.getPrice());
            }
            if (product.getQuantity() != null) {
                productToBeUpdated.setQuantity(product.getQuantity());
            }
            this.productRepository.save(productToBeUpdated);
        }
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> productToBeFound = this.productRepository.findById(id);
        if (productToBeFound.isPresent()) {
            return productToBeFound.get();
        } else {
            throw new ProductNotFoundException("Product with id " + id + " not found!");
        }
    }

    @Override
    public void deleteProductById(Integer id) {
        Optional<Product> productToBeDeleted = this.productRepository.findById(id);
        if (productToBeDeleted.isPresent()) {
            this.productRepository.deleteById(id);
        } else {
            throw new ProductNotFoundException("Product with id " + id + " not found!");
        }
    }
}
