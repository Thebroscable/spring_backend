package com.example.demo.dto.response;

import com.example.demo.entity.Discount;
import lombok.Getter;

@Getter
public class DiscountResponse {

    private Long id;

    private String name;

    private String description;

    private float discount_percent;

    private Boolean active;

    public DiscountResponse(Discount discount) {
        this.id = discount.getId();
        this.name = discount.getName();
        this.description = discount.getDescription();
        this.discount_percent = discount.getDiscount_percent();
        this.active = discount.getActive();
    }
}
