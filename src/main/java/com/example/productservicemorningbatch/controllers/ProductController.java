package com.example.productservicemorningbatch.controllers;

import com.example.productservicemorningbatch.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    //localhost:8080/products/30
    @GetMapping("/{id}")
    public Product  getProductById(@PathVariable("id") Long id){
        return new Product();
    }

    //Gert all Products
    @GetMapping
    public List<Products> getAllProducts(){
        return new ArrayList<>();
    }

    //Create a Product
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }

    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    //replace a product
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    public void deleteProduct(@PathVariable("id") Long id){

    }
}
