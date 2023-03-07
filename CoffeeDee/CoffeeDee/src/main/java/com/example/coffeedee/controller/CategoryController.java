package com.example.coffeedee.controller;

import com.example.coffeedee.dto.response.CategoryResponse;
import com.example.coffeedee.dto.response.ProductResponse;
import com.example.coffeedee.entity.Category;
import com.example.coffeedee.entity.Product;
import com.example.coffeedee.service.CategoryService;
import com.example.coffeedee.service.ProductService;
import com.example.coffeedee.util.CategoryUtils;
import com.example.coffeedee.util.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/coffee_dee")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryService cs;

    @Autowired
    private ProductService ps;

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories() {
        List<Category> categories = cs.getCategories();
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Category c: categories) {
            List<Product> products = ps.getProductsByCategoryId(c.getId());
            for (Product product: products) {
                productResponses.add(ProductUtils.convertToProductResponse(product));
            }
            categoryResponses.add(CategoryUtils.convertToCategoryResponse(c, productResponses));
            productResponses= new ArrayList<>();
        }

        return ResponseEntity.ok().body(categoryResponses);
    }
}
