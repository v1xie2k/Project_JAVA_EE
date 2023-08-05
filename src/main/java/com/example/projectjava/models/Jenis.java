package com.example.projectjava.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "jenis")
@Getter
@Setter
public class Jenis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generate by mysql
    private int id;
    private String value;


    @OneToMany(mappedBy = "jenis")
    private List<Htrans> transaksis;

//    @OneToMany(mappedBy = "jenis", cascade = CascadeType.ALL)
//    @JoinColumn(name = "jenis_id", referencedColumnName = "jenis_id")
//    private List<Htrans> transaksis;
}
