package com.example.demo.entity;

import com.example.demo.dto.request.DiscountRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "store", name = "discount")
public class Discount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull
    private float discount_percent;

    @Column(columnDefinition = "boolean default false")
    private Boolean active;

    public void setVariablesByRequest(DiscountRequest discountRequest) {
        this.name = discountRequest.getName();
        this.description = discountRequest.getDescription();
        this.discount_percent = discountRequest.getDiscount_percent();
        this.active = discountRequest.getActive();
    }
}
