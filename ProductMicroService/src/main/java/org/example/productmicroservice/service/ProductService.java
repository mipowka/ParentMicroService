package org.example.productmicroservice.service;

import lombok.RequiredArgsConstructor;
import org.example.productmicroservice.model.entity.Product;
import org.example.productmicroservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
    }

}
