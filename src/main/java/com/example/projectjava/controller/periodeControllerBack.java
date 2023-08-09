package com.example.projectjava.controller;


import com.example.projectjava.models.Periode;
import com.example.projectjava.services.PeriodeServices;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/periode")

public class periodeControllerBack {
    @Autowired
    PeriodeServices service;

    @GetMapping("/getAll")
    public List<Periode> getAllPeriode(){
        return service.getAll();
    }
//    @PostMapping("/save")
//    public ResponseEntity<String> savePeriode(@RequestBody Periode obj){
//        service.save(obj);
//
//        return ResponseEntity.ok("Data Saved");
//    }

    @GetMapping("/")
    public List<Periode> getAllReal(){
        String uri ="http://localhost:8080/periode/getAll";
        RestTemplate restTemplate = new RestTemplate();
        Periode[] result = restTemplate.getForObject(uri,Periode[].class);
        return Arrays.asList(result);
    }

    @PostMapping(
            path = "/save",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    ResponseEntity<String> savePeriode(Periode obj, HttpServletResponse response) throws Exception {
        obj.setId(Integer.parseInt(obj.getTahun()+obj.getBulan()));
        service.save(obj);
        return ResponseEntity.ok("Berhasil input periode!");
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
