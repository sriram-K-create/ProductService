package com.example.productservicemorningbatch.controllers;

import com.example.productservicemorningbatch.models.Product;
import com.example.productservicemorningbatch.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }



    //localhost:8080/products/30
    @GetMapping("/{id}")
    public Product  getProductById(@PathVariable("id") Long id){
       //Call the FakeStore API to get the product id
        return productService.getProductById(id);
    }

    //Get all Products
    @GetMapping
    public List<Product> getAllProducts(){
        return new ArrayList<Product>();
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
