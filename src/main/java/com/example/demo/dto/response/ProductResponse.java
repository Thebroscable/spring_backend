package com.example.demo.dto.response;

import com.example.demo.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponse {

    private Long id;

    private String name;

    private String description;

    private Long category_id;

    private float price;

    private int quantity;

    private Long discount_id;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.category_id = product.getCategory_id();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.discount_id = product.getDiscount_id();
    }
}
