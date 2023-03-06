package com.example.demo.dto.request;

import lombok.Getter;

@Getter
public class ProductRequest {

    private String name;

    private String description;

    private Long category_id;

    private float price;

    private int quantity;

    private Long discount_id;

}
