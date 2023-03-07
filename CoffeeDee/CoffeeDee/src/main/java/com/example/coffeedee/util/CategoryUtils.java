package com.example.coffeedee.util;

import com.example.coffeedee.dto.response.CategoryResponse;
import com.example.coffeedee.dto.response.ProductResponse;
import com.example.coffeedee.entity.Category;

import java.util.List;

public class CategoryUtils {
    public static CategoryResponse convertToCategoryResponse(Category category, List<ProductResponse> productResponses) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setCategoryName(category.getCategoryName());
        categoryResponse.setDescription(category.getDescription());
        categoryResponse.setProductResponses(productResponses);

        return categoryResponse;
    }

}
