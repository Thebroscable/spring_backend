package com.example.demo.service;

import com.example.demo.dto.request.ProductRequest;
import com.example.demo.dto.response.ProductResponse;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductResponse getProductById(Long productId) {
        Product product = productRepository.getReferenceById(productId);
        return new ProductResponse(product);
    }

    public List<ProductResponse> getAllProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<ProductResponse>();
        for (Product product : products) {
            productResponses.add(new ProductResponse(product));
        }
        return productResponses;
    }

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setVariablesByRequest(productRequest);

        Product savedProduct = productRepository.save(product);
        return new ProductResponse(savedProduct);
    }

    public ProductResponse updateProductById(ProductRequest productRequest, Long productId) {
        Product product = productRepository.getReferenceById(productId);
        product.setVariablesByRequest(productRequest);

        Product savedProduct = productRepository.save(product);
        return new ProductResponse(savedProduct);
    }

    public void deleteProduct(Long productId) {
        Product product = productRepository.getReferenceById(productId);
        productRepository.delete(product);
    }
}
