package com.example.demo.controller;

import com.example.demo.dto.request.ProductCategoryRequest;
import com.example.demo.dto.response.ProductCategoryResponse;
import com.example.demo.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/product_category")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{productCategoryId}")
    public ResponseEntity<ProductCategoryResponse> getProductCategoryById(@PathVariable Long productCategoryId) {
        return ResponseEntity.ok(productCategoryService.getProductCategoryById(productCategoryId));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/")
    public ResponseEntity<List<ProductCategoryResponse>> getAllProductCategory() {
        return ResponseEntity.ok(productCategoryService.getAllProductCategory());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/")
    public ResponseEntity<ProductCategoryResponse> createProductCategory(@RequestBody ProductCategoryRequest productCategoryRequest) {
        return ResponseEntity.ok(productCategoryService.createProductCategory(productCategoryRequest));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{productCategoryId}")
    public ResponseEntity<ProductCategoryResponse> updateProductCategory(@RequestBody ProductCategoryRequest productCategoryRequest,
                                                                         @PathVariable Long productCategoryId) {
        return ResponseEntity.ok(productCategoryService.updateProductCategory(productCategoryRequest, productCategoryId));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{productCategoryId}")
    public ResponseEntity<Void> deleteProductCategory(@PathVariable Long productCategoryId) {
        productCategoryService.deleteProductCategory(productCategoryId);
        return ResponseEntity.ok().build();
    }
}
