package com.example.projectjava.controller;

import com.example.projectjava.models.EmployeeList;
import com.example.projectjava.models.Htrans;
import com.example.projectjava.models.Jenis;
import com.example.projectjava.services.HtransServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class TransaksiControllerFront {
    @Autowired
    HtransServices service;
    @Autowired
    jenisControllerBack jenisControllerBack;

    //@RequestMapping("/trans/")
    //public String bukaIndex(Model model){
        //List<Transaksi> daftarTrans = service.getByPeriode();

//        List<Transaksi> daftarBudget = service.getByStatus(0);
      //  model.addAttribute("trans", daftarTrans);
//        model.addAttribute("budget",daftarBudget);
        //return "index";
    //}


    @RequestMapping("/createTrans")
    public String bukaFormTrans(Model model){
        Htrans baru = new Htrans();
        List< Jenis> jenis = jenisControllerBack.getAllReal();
        model.addAttribute("jenis",jenis);
        model.addAttribute("htrans",baru);
        return "createTrans";
    }

    @RequestMapping("/createPeriode")
    public String bukaFormPeriode(){
        return "createPeriode";
    }

    @RequestMapping("/createUser")
    public String bukaFormUser(){
        return "createUser";
    }

    @RequestMapping("/createBudget")
    public String bukaFormBudget(){
        return "createBudget";
    }

}
