package com.example.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

import lombok.*;

@Entity
@Table(name = "products")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Store all product types in one table
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product(String name, String description, BigDecimal price, int quantity, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

}
