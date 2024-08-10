package com.example.productservicemorningbatch.services;

import com.example.productservicemorningbatch.dtos.FakeStoreProductDto;
import com.example.productservicemorningbatch.models.Category;
import com.example.productservicemorningbatch.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.http.HttpMethod;

import java.util.ArrayList;
import java.util.List;
//Some Companies use iFakeStoreProductService or FakeStoreProductServiceImpl
@Service
public class FakeStoreProductService implements  ProductService{
    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        //Convert FakeStoreProductDto to Product Object
        if(fakeStoreProductDto ==  null){
            return null;
        }
        //convert fakeStoreProductDto to Product object
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);


    }
    @Override
    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        FakeStoreProductDto[] fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreProductDto[].class);
                if(fakeStoreProductDto == null){return allProducts;}

                for(FakeStoreProductDto productDto: fakeStoreProductDto){
                    Product product = convertFakeStoreProductDtoToProduct(productDto);
                    allProducts.add(product);
                }
                return allProducts;
    }

    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        //PUT Method
        //Replace the Product given id with input Product
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class,restTemplate.getMessageConverters());
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
