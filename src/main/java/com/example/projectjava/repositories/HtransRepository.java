package com.example.projectjava.repositories;

import com.example.projectjava.models.Htrans;
import com.example.projectjava.models.Periode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HtransRepository extends JpaRepository<Htrans, Integer> {
    public List<Htrans> findByUserIdAndPeriodeId(Integer idperiode, Integer iduser);

}
