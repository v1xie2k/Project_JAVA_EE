package com.example.projectjava.controller;

import com.example.projectjava.models.Periode;
import com.example.projectjava.models.User;
import com.example.projectjava.services.PeriodeServices;
import com.example.projectjava.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/periode")
public class PeriodeController {
    @Autowired
    PeriodeServices service;

    @GetMapping("/")
    public List<Periode> getAllPeriode(){
        return service.getAll();
    }
//    @PostMapping("/save")
//    public ResponseEntity<String> savePeriode(@RequestBody Periode obj){
//        service.save(obj);
//
//        return ResponseEntity.ok("Data Saved");
//    }

    @PostMapping(
            path = "/save",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String savePeriode(Periode obj) throws Exception {
        service.save(obj);
        return "Success Add Periode";
    }
}
