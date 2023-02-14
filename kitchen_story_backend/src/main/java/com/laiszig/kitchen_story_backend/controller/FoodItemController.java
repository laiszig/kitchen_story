package com.laiszig.kitchen_story_backend.controller;

import com.laiszig.kitchen_story_backend.entity.FoodItem;
import com.laiszig.kitchen_story_backend.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping("/items")
    public List<FoodItem> getAll() {
        return foodItemService.findAll();
    }

    @PostMapping("/items")
    public ResponseEntity<FoodItem> saveItem(@RequestBody FoodItem foodItem) {
        foodItemService.saveFoodItem(foodItem);
        return new ResponseEntity<>(foodItem, HttpStatus.CREATED);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<FoodItem> getItem(@PathVariable Integer id) {
        try {
            FoodItem foodItem = foodItemService.getFoodItem(id);
            return new ResponseEntity<>(foodItem, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<FoodItem> deleteCategory (@PathVariable Integer id) {
        try {
            foodItemService.deleteFoodItem(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
