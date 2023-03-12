package com.vichar.controller;

import com.vichar.DTO.CategoryDTO;
import com.vichar.DTO.UserDTO;
import com.vichar.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vichar/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDTO> addCategoryHandler(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO categoryDTO1 = this.categoryService.addCategory(categoryDTO);
        return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<CategoryDTO> updateCategoryHandler(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO categoryDTO1 = this.categoryService.updateCategory(categoryDTO);
        return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{catid}")
    public ResponseEntity<String> deleteCategoryHandler(@Valid @PathVariable Integer catid) {
        String categoryDTO1 = this.categoryService.deleteCategory(catid);
        return new ResponseEntity<>(categoryDTO1, HttpStatus.CREATED);
    }

    @GetMapping("/{catid}")
    public ResponseEntity<CategoryDTO> getCategoryByIdHandler(@Valid @PathVariable Integer catid) {
        CategoryDTO categoryDTO1 = this.categoryService.getCategoryById(catid);
        return new ResponseEntity<>(categoryDTO1, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategoryHandler() {
        List<CategoryDTO> categoryDTO1 = this.categoryService.getAllCategories();
        return new ResponseEntity<>(categoryDTO1, HttpStatus.CREATED);
    }


}
