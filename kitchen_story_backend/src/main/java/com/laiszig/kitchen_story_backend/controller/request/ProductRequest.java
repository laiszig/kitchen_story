package com.laiszig.kitchen_story_backend.controller.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    private Integer category;

    private String name;

    private BigDecimal price;
}
