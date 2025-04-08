package com.example.backend.Service;

import com.example.backend.Model.Category;

import java.util.List;

public interface CategoryService {
    List<Category>getAllCategories();
    Category addCategory(Category category);
    Category getCategoryById(Long id);
    boolean deleteCategoryById(Long id); // Add this method
}

