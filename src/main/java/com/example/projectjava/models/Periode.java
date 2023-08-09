package com.example.projectjava.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "periode")
@Getter
@Setter
public class Periode {
    @Id
    private int id;
    private String bulan;
    private String tahun;


}
