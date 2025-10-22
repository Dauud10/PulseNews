package com.example.backend.Controller;

import com.example.backend.DTO.CategoryDTO;  // Correct import
import com.example.backend.Model.Category;
import com.example.backend.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8084")
@RestController
@RequestMapping("/categories")
@Validated
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    private CategoryDTO convertToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setName(category.getName());
        return dto;
    }

    private Category convertToEntity(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());

    // Convert Category to CategoryDTO
    private CategoryDTO convertToDTO(Category category) {
        return new CategoryDTO(category.getId(), category.getName());
    }

    // Convert CategoryDTO to Category
    private Category convertToEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());

        return category;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();

        List<CategoryDTO> dtoList = categories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);

        List<CategoryDTO> categoryDTOs = categories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(categoryDTOs);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(convertToDTO(category));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO dto) {
        Category saved = categoryService.addCategory(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(saved), HttpStatus.CREATED);

        CategoryDTO categoryDTO = convertToDTO(category);
        return ResponseEntity.ok(categoryDTO);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        Category category = convertToEntity(categoryDTO);
        Category savedCategory = categoryService.addCategory(category);
        CategoryDTO savedCategoryDTO = convertToDTO(savedCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategoryDTO);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO dto) {
        Category existing = categoryService.getCategoryById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        existing.setName(dto.getName());
        Category updated = categoryService.addCategory(existing);
        return ResponseEntity.ok(convertToDTO(updated));

        categoryDTO.setId(id); // Ensure correct ID
        Category category = convertToEntity(categoryDTO);
        Category savedCategory = categoryService.addCategory(category);
        CategoryDTO savedCategoryDTO = convertToDTO(savedCategory);
        return ResponseEntity.ok(savedCategoryDTO);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        boolean deleted = categoryService.deleteCategoryById(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found!");
        }
        return ResponseEntity.ok("Category deleted successfully!");
    }
}


