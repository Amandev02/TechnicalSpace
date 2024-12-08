package com.example.TechnicalSpace.controllers;

import com.example.TechnicalSpace.config.AppConstants;
import com.example.TechnicalSpace.payload.CategoryResponse;
import com.example.TechnicalSpace.payload.categoryDTO;
import com.example.TechnicalSpace.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    public CategoryController(CategoryService categoryService){
//        this.categoryService = categoryService;
//    }

    @GetMapping("/api/public/categories")
    public ResponseEntity<CategoryResponse> getAllCategories(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name="pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name="sortBy", defaultValue = AppConstants.SORT_CATEGORIES_BY, required = false) String sortBy,
            @RequestParam(name="sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder
    ){
        CategoryResponse categoryResponse = categoryService.getAllCategories(pageNumber,pageSize,sortBy,sortOrder);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PostMapping("/api/admin/categories")
    public ResponseEntity<categoryDTO> createCategory(@Valid @RequestBody categoryDTO categoryDTO){
        categoryDTO savedCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }

    @PutMapping("/api/admin/categories/{categoriesID}")
    public ResponseEntity<categoryDTO> updateCategory(@Valid @PathVariable Long categoriesID, @RequestBody categoryDTO categorydto){
        categoryDTO savedCategoryDTO =  categoryService.updateCategory(categoriesID,categorydto);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);

    }

    @DeleteMapping("/api/admin/categories/{categoriesId}")
    public ResponseEntity<categoryDTO> deleteCategories(@PathVariable Long categoriesId) {
        categoryDTO deletedDTO = categoryService.deleteCategory(categoriesId);
        return new ResponseEntity<>(deletedDTO, HttpStatus.OK);
    }


}
