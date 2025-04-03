package com.example.factory;

import java.util.HashMap;
import java.util.Map;

public class ProductFactoryProvider {
    private static final Map<String, ProductFactory> factoryMap = new HashMap<>();

    static {
        factoryMap.put("PHYSICAL", new PhysicalProductFactory());
        factoryMap.put("DIGITAL", new DigitalProductFactory());
        factoryMap.put("SERVICE", new ServiceProductFactory());
    }

    public static ProductFactory getFactory(String productType) {
        return factoryMap.getOrDefault(productType.toUpperCase(), null);
    }
}

