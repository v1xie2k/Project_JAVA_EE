package com.example.projectjava.controller;


import com.example.projectjava.models.Periode;
import com.example.projectjava.services.PeriodeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/periode")

public class periodeControllerBack {
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
        return "redirect:/success";
    }

    @GetMapping("/success")
    public ResponseEntity<String> getSuccess() {
        return new ResponseEntity<String>("Success Add Periode", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public List<Periode> getSpecificPeriode(@PathVariable String id){
        return service.getSpecific(id);
    }
}
