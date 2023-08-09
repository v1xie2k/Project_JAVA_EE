package com.example.projectjava.controller;

import com.example.projectjava.models.User;
import com.example.projectjava.services.UserServices;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServices service;

    @GetMapping("/getAll")
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

    @GetMapping("/")
    public List<User> getAllReal(){
        String uri ="http://localhost:8080/user/getAll";
        RestTemplate restTemplate = new RestTemplate();
        User[] result = restTemplate.getForObject(uri,User[].class);
        return Arrays.asList(result);
    }

    @PostMapping(
            path = "/save",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    ResponseEntity<String> saveUser(User obj, HttpServletResponse response) throws Exception {
        service.save(obj);
        return ResponseEntity.ok("Berhasil tambah user!");
    }

    @GetMapping("/success")
    public ResponseEntity<String> getSuccess() {
        return new ResponseEntity<String>("Success Add User", HttpStatus.OK);
    }
}
