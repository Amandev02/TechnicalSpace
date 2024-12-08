package com.example.TechnicalSpace.repositories;

import com.example.TechnicalSpace.models.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("Select c from Category c where c.categoryName = ?1")
    Category findByCategoryName(@NotBlank @Size(min = 5, message = "Category name must contain atleast 5 characters") String categoryName);
}
