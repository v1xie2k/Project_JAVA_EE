package com.example.projectjava.services;

import com.example.projectjava.models.Jenis;
import com.example.projectjava.models.Periode;
import com.example.projectjava.repositories.JenisRepository;
import com.example.projectjava.repositories.PeriodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JenisServices {
    @Autowired
    JenisRepository repo;
    public void save(Jenis obj){
        repo.save(obj);
    }

    public List<Jenis> getAll(){
        return repo.findAll();
    }
}
