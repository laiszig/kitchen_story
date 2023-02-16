package com.laiszig.kitchen_story_backend.controller;

import com.laiszig.kitchen_story_backend.entity.FoodItem;
import com.laiszig.kitchen_story_backend.entity.OrderItem;
import com.laiszig.kitchen_story_backend.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/orderitem")
    public List<OrderItem> getAll() {
        return orderItemService.findAll();
    }

    @PostMapping("/orderitem")
    public ResponseEntity<OrderItem> saveOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.saveOrderItem(orderItem);
        return new ResponseEntity<>(orderItem, HttpStatus.CREATED);
    }

    @GetMapping("/orderitem/{id}")
    public ResponseEntity<OrderItem> getOrderItem(@PathVariable Integer id) {
        try {
            OrderItem orderItem = orderItemService.getOrderItem(id);
            return new ResponseEntity<>(orderItem, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/orderitem/{id}")
    public ResponseEntity<OrderItem> deleteCategory (@PathVariable Integer id) {
        try {
            orderItemService.deleteOrderItem(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
