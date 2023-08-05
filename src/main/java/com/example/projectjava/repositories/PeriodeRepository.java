package com.example.projectjava.repositories;

import com.example.projectjava.models.Periode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeriodeRepository extends JpaRepository<Periode, Integer> {
    public List<Periode> findByBulan(String bulan);

}
