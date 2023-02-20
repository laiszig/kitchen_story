package com.laiszig.kitchen_story_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "food_items")
public class Product {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "item_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

    @Column(name = "item_price")
    private BigDecimal price;
}
