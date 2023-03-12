package com.vichar.service;

import com.vichar.DTO.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public CategoryDTO addCategory(CategoryDTO categoryDTO);

    public CategoryDTO updateCategory(CategoryDTO categoryDTO);

    public String deleteCategory(Integer catId);

    public CategoryDTO getCategoryById(Integer catId);

    public List<CategoryDTO> getAllCategories();
}
