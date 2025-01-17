package com.example.jwtpracticeapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtpracticeapp.models.User;
import com.example.jwtpracticeapp.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return service.verify(user);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.register(user);
    }
}
