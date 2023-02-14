package com.laiszig.kitchen_story_backend.service;

import com.laiszig.kitchen_story_backend.entity.Category;
import com.laiszig.kitchen_story_backend.entity.FoodItem;
import com.laiszig.kitchen_story_backend.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    FoodItemRepository foodItemRepository;

    public List<FoodItem> findAll() {
        return foodItemRepository.findAll();
    }

    public void saveFoodItem(FoodItem foodItem) {
        foodItemRepository.save(foodItem);
    }

    public FoodItem getFoodItem(Integer id) {
        return foodItemRepository.findById(id).get();
    }

    public void deleteFoodItem(Integer id) {
        foodItemRepository.deleteById(id);
    }
}
