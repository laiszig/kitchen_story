package com.laiszig.kitchen_story_backend.controller;

import com.laiszig.kitchen_story_backend.entity.FoodItem;
import com.laiszig.kitchen_story_backend.entity.User;
import com.laiszig.kitchen_story_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/user/changepassword")
    public void changePassword () {
    }

    @PostMapping("/user/changepassword")
    public void changePassword2 () {
    }

}
