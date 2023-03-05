package com.laiszig.kitchen_story_backend.service;

import com.laiszig.kitchen_story_backend.controller.request.ProductRequest;
import com.laiszig.kitchen_story_backend.entity.Product;
import com.laiszig.kitchen_story_backend.repository.CategoryRepository;
import com.laiszig.kitchen_story_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> searchByCategory (Integer id){
        return productRepository.findByCategoryId(id);
    }

    public void saveFoodItem(ProductRequest productRequest) {
        Product product = new Product();
        product.setPrice(productRequest.getPrice());
        product.setName(productRequest.getName());
        product.setCategory(categoryRepository.findById(productRequest.getCategory()).get());
        productRepository.save(product);
    }

    public Product getFoodItem(Integer id) {
        return productRepository.findById(id).get();
    }

    public void deleteFoodItem(Integer id) {
        productRepository.deleteById(id);
    }
}
