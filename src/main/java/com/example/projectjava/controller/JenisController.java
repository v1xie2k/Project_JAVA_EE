package com.example.projectjava.controller;

import com.example.projectjava.models.Jenis;
import com.example.projectjava.services.JenisServices;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jenis")
public class JenisController {
    @Autowired
    JenisServices service;

    @GetMapping("/")
    public List<Jenis> getAllJenis(){
        return service.getAll();
    }

    @PostMapping(
            path = "/save",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    ResponseEntity<String> saveJenis(Jenis obj, HttpServletResponse response) throws Exception {
        service.save(obj);
        return ResponseEntity.ok("Berhasil input pos!");
    }
    @GetMapping("/success")
    public ResponseEntity<String> getSuccess() {
        return new ResponseEntity<String>("Success Add Jenis", HttpStatus.OK);
    }
}
