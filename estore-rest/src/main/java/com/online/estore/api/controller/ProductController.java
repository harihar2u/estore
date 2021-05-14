package com.online.estore.api.controller;

import com.online.estore.core.entity.Product;
import com.online.estore.core.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Optional;


@RestController
public class ProductController {
    private static final Logger LOG = LoggerFactory.getLogger("ProductController");

    @Inject
    private ProductRepository productRepository;

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Page<Product>> getProducts(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Optional product = productRepository.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity(product, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/products", consumes = "application/json")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        productRepository.save(product);

        return ResponseEntity.accepted().body(product);
    }

}
