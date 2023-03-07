package com.example.coffeedee.util;

import com.example.coffeedee.dto.response.ProductResponse;
import com.example.coffeedee.entity.Product;

public class ProductUtils {
    public static ProductResponse convertToProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setProductName(product.getProductName());
        productResponse.setDescription(product.getDescription());
        productResponse.setImage(product.getImage());
        productResponse.setPrice(product.getPrice());

        return productResponse;
    }
}
