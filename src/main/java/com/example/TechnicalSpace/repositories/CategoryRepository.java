package com.example.TechnicalSpace.repositories;

import com.example.TechnicalSpace.models.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {


    Category findByCategoryName(@NotBlank @Size(min = 5, message = "Category name must contain atleast 5 characters") String categoryName);
}