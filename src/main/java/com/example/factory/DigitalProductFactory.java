package com.example.factory;
import com.example.model.Category;
import com.example.model.DigitalProduct;
import com.example.model.Product;

import java.math.BigDecimal;
import java.util.Map;

public class DigitalProductFactory implements ProductFactory {
    @Override
    public Product createProduct(String name, String description, BigDecimal price, int quantity, Category category, Map<String, Object> additionalAttributes) {
        String fileFormat = (String) additionalAttributes.getOrDefault("fileFormat", "Unknown");
        double fileSize = (double) additionalAttributes.getOrDefault("fileSize", 0.0);
        return new DigitalProduct(
        name,
        description,
        price,
        quantity,
        category,
        fileFormat,
        fileSize
        );
    }
}

