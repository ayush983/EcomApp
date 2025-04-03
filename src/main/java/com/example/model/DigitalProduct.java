package com.example.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("DIGITAL")
public class DigitalProduct extends Product {
    private String fileFormat; // e.g., PDF, MP3, MP4
    private double fileSize; // File size in MB

    public DigitalProduct(String name, String description, BigDecimal price, int quantity, Category category, String fileFormat, double fileSize) {
        super(name, description, price, quantity, category);
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
    }
}

