package com.example.demo.entity;

import com.example.demo.dto.request.DiscountRequest;
import com.example.demo.dto.request.ProductRequest;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "store", name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Long category_id;

    private float price;

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
