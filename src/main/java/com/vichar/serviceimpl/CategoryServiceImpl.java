package com.vichar.serviceimpl;

import com.vichar.DTO.CategoryDTO;
import com.vichar.exception.CategotyException;
import com.vichar.model.Category;
import com.vichar.repository.CategoryDao;
import com.vichar.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category category = this.modelMapper.map(categoryDTO, Category.class);
        Category category1 = this.categoryDao.save(category);
        return this.modelMapper.map(category1, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        Category category = this.categoryDao.findById(categoryDTO.getId()).orElseThrow(() -> new CategotyException(
                "Category Not found with this id : " + categoryDTO.getId()));

        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setCategoryDescription(categoryDTO.getCategoryDescription());

        Category category1 = this.categoryDao.save(category);

        return this.modelMapper.map(category1, CategoryDTO.class);

    }

    @Override
    public String deleteCategory(Integer catId) {
        Category category = this.categoryDao.findById(catId).orElseThrow(() -> new CategotyException(
                "Category Not found with this id : " + catId));

        this.categoryDao.delete(category);
        return "Category delete succesfully";
    }

    @Override
    public CategoryDTO getCategoryById(Integer catId) {
        Category category = this.categoryDao.findById(catId).orElseThrow(() -> new CategotyException(
                "Category Not found with this id : " + catId));

        return this.modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = this.categoryDao.findAll();

        List<CategoryDTO> categoryDTOS = categories.stream().map(category -> this.modelMapper.map(category,
                CategoryDTO.class)).collect(Collectors.toList());

        return categoryDTOS;
    }
}
