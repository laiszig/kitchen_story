package com.laiszig.kitchen_story_backend.service;

import com.laiszig.kitchen_story_backend.entity.Order;
import com.laiszig.kitchen_story_backend.entity.OrderItem;
import com.laiszig.kitchen_story_backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public Order getOrder(Integer id) {
        return orderRepository.findById(id).get();
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
