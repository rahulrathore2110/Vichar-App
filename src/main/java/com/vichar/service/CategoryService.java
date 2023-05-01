package com.vichar.service;

import com.vichar.DTO.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    CategoryDTO addCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(CategoryDTO categoryDTO);

    String deleteCategory(Integer catId);

    CategoryDTO getCategoryById(Integer catId);

    List<CategoryDTO> getAllCategories();
}
