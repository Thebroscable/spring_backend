package com.example.demo.dto.response;

import com.example.demo.entity.ProductCategory;
import lombok.Getter;

@Getter
public class ProductCategoryResponse {

    private Long id;

    private String name;

    private String description;

    public ProductCategoryResponse(ProductCategory productCategory) {
        this.id = productCategory.getId();
        this.name = productCategory.getName();
        this.description = productCategory.getDescription();
    }
}
