package com.example.demo.entity;

import com.example.demo.dto.request.DiscountRequest;
import com.example.demo.dto.request.ProductRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "store", name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull
    private Long category_id;

    @NotNull
    private float price;

    @NotNull
    private int quantity;

    private Long discount_id;

    public void setVariablesByRequest(ProductRequest productRequest) {
        this.name = productRequest.getName();
        this.description = productRequest.getDescription();
        this.category_id = productRequest.getCategory_id();
        this.price = productRequest.getPrice();
        this.quantity = productRequest.getQuantity();
        this.discount_id = productRequest.getDiscount_id();
    }
}
