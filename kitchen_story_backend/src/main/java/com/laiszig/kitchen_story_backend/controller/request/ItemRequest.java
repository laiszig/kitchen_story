package com.laiszig.kitchen_story_backend.controller.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemRequest {

    private Integer id;
    private Integer quantity;
    private BigDecimal price;
}
