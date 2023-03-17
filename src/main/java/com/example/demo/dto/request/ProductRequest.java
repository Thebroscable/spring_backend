package com.example.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProductRequest {

    private String name;

    private String description;

    private Long category_id;

    private float price;

    private int quantity;

    private Long discount_id;

}
