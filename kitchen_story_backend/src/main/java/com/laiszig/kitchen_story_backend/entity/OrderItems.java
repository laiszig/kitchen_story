package com.laiszig.kitchen_story_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "order_items")
public class OrderItems {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = true)
    private FoodItem foodItem;

    @Column(name = "order_item_quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

}
