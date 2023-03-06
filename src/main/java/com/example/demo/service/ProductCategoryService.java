package com.example.demo.service;

import com.example.demo.dto.request.ProductCategoryRequest;
import com.example.demo.dto.response.ProductCategoryResponse;
import com.example.demo.entity.ProductCategory;
import com.example.demo.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryResponse getProductCategoryById(Long productCategoryId) {
        ProductCategory productCategory = productCategoryRepository.getReferenceById(productCategoryId);
        return new ProductCategoryResponse(productCategory);
    }

    public List<ProductCategoryResponse> getAllProductCategory() {
        List<ProductCategory> productCategories = productCategoryRepository.findAll();
        List<ProductCategoryResponse> productCategoryResponses = new ArrayList<ProductCategoryResponse>();
        for (ProductCategory productCategory : productCategories) {
            productCategoryResponses.add(new ProductCategoryResponse(productCategory));
        }
        return productCategoryResponses;
    }

    public ProductCategoryResponse createProductCategory(ProductCategoryRequest productCategoryRequest) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setVariablesByRequest(productCategoryRequest);

        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        return new ProductCategoryResponse(savedProductCategory);
    }

    public ProductCategoryResponse updateProductCategory(ProductCategoryRequest productCategoryRequest,
                                                         Long productCategoryId) {
        ProductCategory productCategory = productCategoryRepository.getReferenceById(productCategoryId);
        productCategory.setVariablesByRequest(productCategoryRequest);

        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        return new ProductCategoryResponse(savedProductCategory);
    }

    public void deleteProductCategory(Long productCategoryId) {
        ProductCategory productCategory = productCategoryRepository.getReferenceById(productCategoryId);
        productCategoryRepository.delete(productCategory);
    }
}
