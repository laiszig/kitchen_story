package com.laiszig.kitchen_story_backend.repository;

import com.laiszig.kitchen_story_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

        List<Product> findByCategoryId (Integer categoryId);
        }
