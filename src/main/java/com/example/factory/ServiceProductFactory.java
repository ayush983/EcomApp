package com.example.factory;
import com.example.model.Category;
import com.example.model.Product;
import com.example.model.ServiceProduct;

import java.math.BigDecimal;
import java.util.Map;

import java.time.Duration;

public class ServiceProductFactory implements ProductFactory {
    @Override
    public Product createProduct(String name, String description, BigDecimal price, int quantity, Category category, Map<String, Object> additionalAttributes) {
        Integer validityPeriod = (Integer) additionalAttributes.getOrDefault("validityPeriod", Duration.ofDays(30));
        return new ServiceProduct(
                name,
                description,
                price,
                quantity,
                category,
                validityPeriod
        );
    }
}


