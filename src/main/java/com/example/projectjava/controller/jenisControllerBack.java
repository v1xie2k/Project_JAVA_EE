package com.example.projectjava.controller;

import com.example.projectjava.models.Jenis;
import com.example.projectjava.services.JenisServices;
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
@RequestMapping("/jenisback")
public class jenisControllerBack {
    @Autowired
    JenisServices service;

    @RequestMapping("/getAll")
    public List<Jenis> getAllJenis(){
        return service.getAll();
    }

    @GetMapping("/")
    public List<Jenis> getAllReal(){
        String uri ="http://localhost:8080/jenis/getAll";
        RestTemplate restTemplate = new RestTemplate();
        Jenis[] result = restTemplate.getForObject(uri,Jenis[].class);
        return Arrays.asList(result);
    }

    @PostMapping(
            path = "/save",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String saveJenis(Jenis obj) throws Exception {
        service.save(obj);
        return "redirect:/success";
    }
    @GetMapping("/success")
    public ResponseEntity<String> getSuccess() {
        return new ResponseEntity<String>("Success Add Jenis", HttpStatus.OK);
    }
}
