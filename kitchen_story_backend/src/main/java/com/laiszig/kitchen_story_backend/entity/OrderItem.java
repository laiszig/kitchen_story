package com.laiszig.kitchen_story_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @Column (name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = true)
    private Product product;

    @Column(name = "order_item_quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

}
