package com.example.service;

import com.example.dto.ProductRequest;
import com.example.factory.ProductFactory;
import com.example.factory.ProductFactoryProvider;
import com.example.model.Category;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryService categoryService;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    //  Save a product
    public Product saveProduct(ProductRequest productRequest) {

        Category category = categoryService.getOrCreateCategoryByName(productRequest.getCategoryName());
        ProductFactory productFactory = ProductFactoryProvider.getFactory(productRequest.getProductType());
        Product product = productFactory.createProduct(
                productRequest.getName(),
                productRequest.getDescription(),
                productRequest.getPrice(),
                productRequest.getQuantity(),
                category,
                productRequest.getAdditionalAttributes()
        );
        return productRepository.save(product);
    }

    //  Fetch all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //  Fetch product by ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    //  Delete product by ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
