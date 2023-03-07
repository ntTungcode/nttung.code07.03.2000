package com.example.coffeedee.service.impl;

import com.example.coffeedee.entity.Category;
import com.example.coffeedee.repository.CategoryRepository;
import com.example.coffeedee.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository cr;

    @Override
    public List<Category> getCategories() {
        return cr.getCategories();
    }
}
