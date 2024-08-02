package com.example.productservicemorningbatch.services;

import com.example.productservicemorningbatch.models.Product;
import org.springframework.stereotype.Service;
import java.util.List;

//write service as an interface to give room for multiple implementation of this
public interface ProductService {
    Product getProductById(Long id);
        //Here we'll call FakestoreAPI to get the Product

    List<Product> getAllProducts();

    Product updateProduct();

    Product replaceProduct();

    Product createProduct();

    void deleteProduct();

}
