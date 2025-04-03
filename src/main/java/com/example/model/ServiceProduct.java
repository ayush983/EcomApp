package com.example.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;
import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("SERVICE")
public class ServiceProduct extends Product {
    private Integer validityPeriod; // Duration of the service

    public ServiceProduct(String name, String description, BigDecimal price, int quantity, Category category, Integer validityPeriod) {
        super(name, description, price, quantity, category);
        this.validityPeriod = validityPeriod;
    }
}

