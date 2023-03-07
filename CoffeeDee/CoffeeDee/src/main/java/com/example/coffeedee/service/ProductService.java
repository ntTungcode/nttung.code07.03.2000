package com.example.coffeedee.service;

import com.example.coffeedee.dto.request.ProductRequest;
import com.example.coffeedee.entity.Product;

import java.util.List;

public interface ProductService {

    Product findProductById(Long id);

    List<Product> getProductsByCategoryId(Long id);
    Product addNewProduct(ProductRequest productReq);

    String updateProduct(Long id, ProductRequest productReq);

    String deleteProduct(Long id);

    List<Product> searchProduct(String searchText);
}
