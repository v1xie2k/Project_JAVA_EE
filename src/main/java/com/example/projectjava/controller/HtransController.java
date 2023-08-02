package com.example.projectjava.controller;

import com.example.projectjava.models.Htrans;
import com.example.projectjava.models.Jenis;
import com.example.projectjava.services.HtransServices;
import com.example.projectjava.services.JenisServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/htrans")

public class HtransController {
    @Autowired
    HtransServices service;

    @GetMapping("/")
    public List<Htrans> getAllJenis(){
        return service.getAll();
    }

    @PostMapping(
            path = "/save",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String saveJenis(Htrans obj) throws Exception {
        service.save(obj);
        return "Success Add Htrans";
    }
}
