package com.example.projectjava.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "htrans")
@Getter
@Setter
public class Htrans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generate by mysql
    private int id_htrans;
    private int id_user;
    private int id_periode;
    private int id_jenis;
    private double jumlah;

    private int status;
    private String nama_user;
    private String periode;
    private String nama_jenis;
}
