package com.example.projectjava.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "db_htrans")
@Getter
@Setter
public class db_htrans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generate by mysql
    private int id_user;
    private int id_periode;
    private int id_jenis;
    private double jumlah;
}
