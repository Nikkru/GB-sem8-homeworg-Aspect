package com.example.sem6apiEx1.controller;

import com.example.sem6apiEx1.model.Product;
import com.example.sem6apiEx1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping
    public List<Product> getAll(){
        return service.getAllProducts();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addNew(@RequestBody Product product){
        return service.createProduct(product);
    }

//    @GetMapping("/{id}")
//    public Product getById(@PathVariable("id") Long id){
//        return service.getProductById(id);
//    }
@GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Product productById;
        try {
            productById = service.getProductById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Product());
        }
        return new ResponseEntity<>(productById, HttpStatus.OK);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return service.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.deleteProduct(id);
    }


}
