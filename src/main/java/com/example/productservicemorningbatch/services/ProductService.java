package com.example.productservicemorningbatch.services;

import com.example.productservicemorningbatch.models.Product;
import org.springframework.stereotype.Service;
import com.example.productservicemorningbatch.dtos.FakeStoreProductDto;
import com.example.productservicemorningbatch.exceptions.InvalidProductIdException;
import java.util.List;
//write service as an interface to give room for multiple implementation of this
public interface ProductService {
    Product getProductById(Long id) throws InvalidProductIdException;
        //Here we'll call FakestoreAPI to get the Product

    List<Product> getAllProducts();

    Product updateProduct();

    Product replaceProduct(Long id,Product productDto);

    Product createProduct();

    void deleteProduct();

}
