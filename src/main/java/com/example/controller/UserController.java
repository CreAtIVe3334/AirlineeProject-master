package com.example.controller;

import com.example.MyResponseEntity;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/user/")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/signup")
    public MyResponseEntity<User> registration(@RequestBody User user){
        return new MyResponseEntity<User>(userService.registration(user), " Mufevveqiyyetle qeydiyyatdan kecdik");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id){
        return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
    }



}
