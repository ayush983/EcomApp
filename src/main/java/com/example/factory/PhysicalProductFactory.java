package com.example.factory;

import com.example.model.*;

import java.math.BigDecimal;
import java.util.Map;

public class PhysicalProductFactory implements ProductFactory {
    @Override
    public Product createProduct(String name, String description, BigDecimal price, int quantity, Category category, Map<String, Object> additionalAttributes) {
        double weight = (double) additionalAttributes.getOrDefault("weight", 0.0);
        String dimensions = (String) additionalAttributes.getOrDefault("dimensions", "N/A");
        return new PhysicalProduct(
                name,
                description,
                price,
                quantity,
                category,
                weight,
                dimensions
        );
    }
}

