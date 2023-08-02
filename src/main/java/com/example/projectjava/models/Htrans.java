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
    private int htransId;
    private int userId;
    private int periodeId;
    private int jenisId;
    private double jumlah;

    private int status;
}
