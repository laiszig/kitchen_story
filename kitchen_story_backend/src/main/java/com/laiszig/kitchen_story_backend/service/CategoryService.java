package com.laiszig.kitchen_story_backend.service;

import com.laiszig.kitchen_story_backend.entity.Category;
import com.laiszig.kitchen_story_backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category getCategory(Integer id) {
        return categoryRepository.findById(id).get();
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
