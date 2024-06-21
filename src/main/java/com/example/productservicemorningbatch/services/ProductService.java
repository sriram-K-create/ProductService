package com.example.productservicemorningbatch.services;

import com.example.productservicemorningbatch.models.Product;

import java.util.List;
public interface ProductService {
    Product getProductById(Long id);

    default List<Product> getAllProducts() {
        return null;
    }

    Product updateProduct();

    Product replaceProduct();

    Product createProduct();

    void deleteProduct();

}
