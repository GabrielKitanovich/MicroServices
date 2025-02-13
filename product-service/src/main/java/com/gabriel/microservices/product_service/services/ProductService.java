package com.gabriel.microservices.product_service.services;

import org.springframework.stereotype.Service;

import com.gabriel.microservices.product_service.dto.ProductRequest;
import com.gabriel.microservices.product_service.model.Product;
import com.gabriel.microservices.product_service.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Saving product: {}", product);
    }
    
}
