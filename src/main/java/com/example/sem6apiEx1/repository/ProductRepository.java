package com.example.sem6apiEx1.repository;

import com.example.sem6apiEx1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
