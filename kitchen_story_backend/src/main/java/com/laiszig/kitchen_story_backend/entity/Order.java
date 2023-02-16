package com.laiszig.kitchen_story_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    private Integer id;

    @Column
    private Integer quantity;

    //TODO: add relationship
//    @JoinColumn(name = "item_id", nullable = true)
//    private FoodItem foodItem;

}
