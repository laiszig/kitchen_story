package com.laiszig.kitchen_story_backend.service;

import com.laiszig.kitchen_story_backend.entity.Customer;
import com.laiszig.kitchen_story_backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void saveUser(Customer customer) {  //TODO: add code
    }
}
