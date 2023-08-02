package com.example.projectjava.repositories;

import com.example.projectjava.models.Periode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodeRepository extends JpaRepository<Periode, Integer> {
}
