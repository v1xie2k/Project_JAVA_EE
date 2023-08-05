package com.example.projectjava.controller;

import com.example.projectjava.models.Htrans;
import com.example.projectjava.models.Jenis;
import com.example.projectjava.models.Periode;
import com.example.projectjava.services.HtransServices;
import com.example.projectjava.services.JenisServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return "redirect:/success";
    }
    //ini coba dari https://www.baeldung.com/spring-url-encoded-form-data
    //kalau tidak bisa di comment saja
    @GetMapping("/success")
    public ResponseEntity<String> getSuccess() {
        return new ResponseEntity<String>("Success Add Htrans", HttpStatus.OK);
    }

    @GetMapping("/{idPeriode}/{idUser}")
    public List<Htrans> getSpecificPeriode(@PathVariable String idPeriode, @PathVariable String idUser){
        Integer id_periode = Integer.parseInt(idPeriode);
        Integer id_user = Integer.parseInt(idUser);

        return service.getFiltered(id_periode, id_user);
    }
}
