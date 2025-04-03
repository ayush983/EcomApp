package com.example.factory;
import com.example.model.Category;
import com.example.model.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface ProductFactory {
    Product createProduct(String name, String description, BigDecimal price, int quantity, Category category, Map<String, Object> additionalAttributes);
}
