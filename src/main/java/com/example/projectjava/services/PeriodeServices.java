package com.example.projectjava.services;

import com.example.projectjava.models.Periode;
import com.example.projectjava.repositories.PeriodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodeServices {

    @Autowired
    PeriodeRepository repo;
    public void save(Periode obj){
        repo.save(obj);
    }

    public List<Periode> getAll(){
        return repo.findAll();
    }

    public List<Periode> getSpecific(String bulan) {

        return repo.findByBulan(bulan);
    }

}
