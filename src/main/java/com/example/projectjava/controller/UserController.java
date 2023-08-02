package com.example.projectjava.controller;

import com.example.projectjava.models.User;
import com.example.projectjava.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServices service;

    @GetMapping("/")
    public List<User> getAllUser(){
        return service.getAll();
    }
//    @PostMapping(
//            path = "/save",
//            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
//    )
//
//    public ResponseEntity<String> saveUser(@RequestBody User obj){
//
//        service.save(obj);
//
//
//        return ResponseEntity.ok("Data Saved");
//    }

    @PostMapping(
            path = "/save",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String saveUser(User obj) throws Exception {
        service.save(obj);
        return "Success Add User";
    }
}
