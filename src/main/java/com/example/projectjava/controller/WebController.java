package com.example.projectjava.controller;

import com.example.projectjava.models.Htrans;
import com.example.projectjava.services.HtransServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    HtransController controller;
    @RequestMapping("/index")
    public String getIndex(Model model) {
//      ini memanggil http://localhost:8080/htrans/getAll
        List<Htrans> htrans = controller.getAllReal();
        model.addAttribute("htrans",htrans);
        return "index";
    }
}
