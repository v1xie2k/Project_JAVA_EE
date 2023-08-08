package com.example.projectjava.controller;

import com.example.projectjava.models.*;
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
    @Autowired
    periodeControllerBack periodeControllerBack;
    @Autowired
    UserController userController;
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
        List<Periode> periode = periodeControllerBack.getAllReal();
        List<User> user = userController.getAllReal();
        model.addAttribute("periode",periode);
        model.addAttribute("jenis",jenis);
        model.addAttribute("user",user);
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

    @RequestMapping("/createJenis")
    public String bukaFormJenis(){
        return "createJenis";
    }

    @RequestMapping("/createBudget")
    public String bukaFormBudget(Model model){
        Htrans baru = new Htrans();
        List< Jenis> jenis = jenisControllerBack.getAllReal();
        List<Periode> periode = periodeControllerBack.getAllReal();
        List<User> user = userController.getAllReal();
        model.addAttribute("periode",periode);
        model.addAttribute("jenis",jenis);
        model.addAttribute("user",user);
        model.addAttribute("htrans",baru);
        return "createBudget";
    }

}
