package com.example.model;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("PHYSICAL")
public class PhysicalProduct extends Product {
    private double weight; // Physical products have weight
    private String dimensions; // Length x Width x Height

    public PhysicalProduct(String name, String description, BigDecimal price, int quantity , Category category, double weight, String dimensions) {
        super(name, description, price, quantity, category);
        this.weight = weight;
        this.dimensions = dimensions;
    }
}

