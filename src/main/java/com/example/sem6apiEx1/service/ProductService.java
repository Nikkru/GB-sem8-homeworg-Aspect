package com.example.sem6apiEx1.service;
import com.example.sem6apiEx1.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(Product product);

    Product createProduct(Product product);

    void deleteProduct(Long id);
}
