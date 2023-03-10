package com.laiszig.kitchen_story_backend.controller;

import com.laiszig.kitchen_story_backend.entity.Customer;
import com.laiszig.kitchen_story_backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/user")
    public List<Customer> getAll() {
        return customerService.findAll();
    }

    @PostMapping("/user")
    public ResponseEntity<Customer> saveUser(@RequestBody Customer customer) {
        customerService.saveUser(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping("/user/changepassword")
    public void changePassword () {
    }

    @PostMapping("/user/changepassword")
    public void changePassword2 () {
    }

}
