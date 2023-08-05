package com.example.projectjava.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generate by mysql
    private int id;
    private String nama;


    @OneToMany(mappedBy = "user")
    private List<Htrans> transaksis;
}
