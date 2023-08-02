package com.example.projectjava.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "db_jenis")
@Getter
@Setter
public class db_jenis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generate by mysql
    private int id_jenis;
    private String value;
}
