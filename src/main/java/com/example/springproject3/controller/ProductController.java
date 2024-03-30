package com.example.springproject3.controller;

import com.example.springproject3.entity.Product;
import com.example.springproject3.repository.ProductRepository;
import com.example.springproject3.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService, ProductRepository productRepository) {
        this.productService = productService;
    }

//    @RequestMapping(method = RequestMethod.GET, path = "/api/products")
    @GetMapping(path = "api/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = this.productService.getAllProduct();
        HttpHeaders headers = new HttpHeaders();
        headers.add("header1", "value1");
        return new ResponseEntity<>(products, headers, HttpStatus.OK);
    }

    @PostMapping("api/product")
    public ResponseEntity<Void> saveProduct(@RequestBody @Valid Product product) {
            this.productService.saveProduct(product);
            HttpHeaders headers = new HttpHeaders();
            headers.add("header1", "value1");
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("api/product/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Integer id) {
            productService.deleteProductById(id);
            HttpHeaders headers = new HttpHeaders();
            headers.add("header1", "value1");
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }

    @GetMapping("api/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
            Product product = productService.getProductById(id);
            HttpHeaders headers = new HttpHeaders();
            headers.add("header1", "value1");
            return new ResponseEntity<>(product, headers, HttpStatus.OK);
    }

    @PatchMapping("api/product/{id}")
    public ResponseEntity<Void> editProduct (@PathVariable Integer id, @RequestBody Product product) {
            productService.editProduct(id, product);
            HttpHeaders headers = new HttpHeaders();
            headers.add("header1", "value1");
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }
}
