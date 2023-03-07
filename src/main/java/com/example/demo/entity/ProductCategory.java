package com.example.demo.entity;

import com.example.demo.dto.request.ProductCategoryRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "store", name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public void setVariablesByRequest(ProductCategoryRequest productCategoryRequest) {
        this.name = productCategoryRequest.getName();
        this.description = productCategoryRequest.getDescription();
    }
}
