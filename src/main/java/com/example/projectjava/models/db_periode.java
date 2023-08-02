package com.example.projectjava.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "db_periode")
@Getter
@Setter

public class db_periode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generate by mysql
    private int id_periode;
    private String bulan;
    private String tahun;
}
