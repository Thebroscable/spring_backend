package com.example.demo.entity;

import com.example.demo.dto.request.ProductCategoryRequest;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "store", name = "product_category")
public class ProductCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public void setVariablesByRequest(ProductCategoryRequest productCategoryRequest) {
        this.name = productCategoryRequest.getName();
        this.description = productCategoryRequest.getDescription();
    }
}
