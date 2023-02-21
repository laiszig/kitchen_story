package com.laiszig.kitchen_story_backend.controller;

import com.laiszig.kitchen_story_backend.entity.Category;
import com.laiszig.kitchen_story_backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(
        origins = "http://localhost:4200"
)
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAll() {
        return categoryService.findAll();
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Integer id) {
        try {
            Category category = categoryService.getCategory(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Category> deleteCategory (@PathVariable Integer id) {
        try {
            categoryService.deleteCategory(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
