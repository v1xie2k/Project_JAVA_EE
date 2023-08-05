package com.example.projectjava.services;

import com.example.projectjava.models.Htrans;
import com.example.projectjava.models.Jenis;
import com.example.projectjava.repositories.HtransRepository;
import com.example.projectjava.repositories.JenisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class HtransServices {
    @Autowired
    HtransRepository repo;
    public void save(Htrans obj){
        repo.save(obj);
    }

    public List<Htrans> getAll(){
        return repo.findAll();
    }

    public List<Htrans> getFiltered(Integer idPeriode, Integer idUser){
        return repo.findByUserIdAndPeriodeId(idPeriode, idUser);
    }
}
