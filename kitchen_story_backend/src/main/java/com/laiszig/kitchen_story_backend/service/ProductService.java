package com.laiszig.kitchen_story_backend.service;

import com.laiszig.kitchen_story_backend.entity.Product;
import com.laiszig.kitchen_story_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void saveFoodItem(Product product) {
        productRepository.save(product);
    }

    public Product getFoodItem(Integer id) {
        return productRepository.findById(id).get();
    }

    public void deleteFoodItem(Integer id) {
        productRepository.deleteById(id);
    }
}
