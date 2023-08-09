package com.example.projectjava.controller;

import com.example.projectjava.models.Htrans;
import com.example.projectjava.models.Periode;
import com.example.projectjava.services.HtransServices;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/htrans")

public class HtransController {
    @Autowired
    HtransServices service;

// ini endpoint api nya
    @RequestMapping("/getAll")
    public List<Htrans> getAllJenis(){
        return service.getOrdered();
    }

// ini memanggil endpoint api
    @GetMapping(value = "/")
    public List<Htrans> getAllReal(){
        String uri = "http://localhost:8080/htrans/getAll";
        RestTemplate restTemplate = new RestTemplate();
        Htrans[] result = restTemplate.getForObject(uri,Htrans[].class);
        return Arrays.asList(result);
    }

    @PostMapping(
            path = "/save",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    ResponseEntity<String> saveJenis(Htrans obj, HttpServletResponse response) throws Exception {

        if(obj.getStatus()==1){
            LocalDate date = LocalDate.parse(obj.getTanggal());
            String month = date.getMonthValue()+"";
            String year = date.getYear()+"";
            Integer idPeriode = Integer.parseInt(year+month);
            Periode periode = new Periode();
            periode.setId(idPeriode);
            obj.setPeriode(periode);
            try {
                service.save(obj);

            }
            catch (Exception ex){
                return ResponseEntity.ok("Gagal Input ! Pengeluaran berada di luar periode budget yang ada !");
            }
            return ResponseEntity.ok("Berhasil Input Pengeluaran!");

        }
        else{
            service.save(obj);
            return ResponseEntity.ok("Berhasil Input Budget!");
        }
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
