package com.laiszig.kitchen_story_backend.service;

import com.laiszig.kitchen_story_backend.entity.Customer;
import com.laiszig.kitchen_story_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<Customer> findAll() {
        return userRepository.findAll();
    }

    public void saveUser(Customer customer) {  //TODO: add code
    }
}
