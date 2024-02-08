package com.example.sem6apiEx1.service.impl;

import com.example.sem6apiEx1.aspect.Registration;
import com.example.sem6apiEx1.model.Product;
import com.example.sem6apiEx1.repository.ProductRepository;
import com.example.sem6apiEx1.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Registration
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

//    @Override
//    public Product getProductById(Long id) {
//        try {
//            return productRepository.getReferenceById(id);
//        } catch (EntityNotFoundException ex){
//            return null;
//        }
//    }
    @Registration
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(
                String.format("Product with id [%d] was not found!", id)));
    }

    @Registration
    @Override
    public Product updateProduct(Product product) {
        Product updateProduct = getProductById(product.getId());

        updateProduct.setName(product.getName());
        updateProduct.setQuantity(product.getQuantity());

        return productRepository.save(updateProduct);
    }

    @Registration
    @Override
    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

    @Registration
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
