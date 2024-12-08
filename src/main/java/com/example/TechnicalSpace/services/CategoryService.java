package com.example.TechnicalSpace.services;

import com.example.TechnicalSpace.payload.CategoryResponse;
import com.example.TechnicalSpace.payload.categoryDTO;
import org.springframework.stereotype.Service;


public interface CategoryService {

    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    categoryDTO createCategory(categoryDTO categoryDTO);
    categoryDTO deleteCategory(Long categoriesId);

    categoryDTO updateCategory(Long categoriesID, categoryDTO categorydto);
}
