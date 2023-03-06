package com.example.demo.dto.request;

import lombok.Getter;

@Getter
public class DiscountRequest {

    private String name;

    private String description;

    private float discount_percent;

    private Boolean active;

}
