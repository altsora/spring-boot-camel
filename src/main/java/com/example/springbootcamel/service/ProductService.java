package com.example.springbootcamel.service;

import com.example.springbootcamel.domain.Product;
import com.example.springbootcamel.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Vergun Alexander
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product findById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            throw new IllegalStateException("Product could not found for given id: " + id);
        }
        return product.get();
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }
}
