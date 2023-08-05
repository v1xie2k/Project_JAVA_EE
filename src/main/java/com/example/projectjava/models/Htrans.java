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
    private int id;
//    private int userId;
//    private int periodeId;
//    private int jenisId;
    private double jumlah;

    private int status;

    @ManyToOne
    @JoinColumn( name = "jenisId")
    private Jenis jenis;

    @ManyToOne
    @JoinColumn( name = "periodeId")
    private Periode periode;

    @ManyToOne
    @JoinColumn( name = "userId")
    private User user;
}
