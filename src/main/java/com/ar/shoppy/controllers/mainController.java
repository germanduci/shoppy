package com.ar.shoppy.controllers;

import com.ar.shoppy.services.clientService;
import com.ar.shoppy.services.fileService;
import com.ar.shoppy.services.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/")
public class mainController {

    @Autowired
    private clientService clientServ;
    @Autowired
    private orderService orderServ;
    @Autowired
    private fileService fileServ;

    public mainController() {
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("Clientes", clientServ.clientListAll());
        model.addAttribute("Ordenes", orderServ.orderListAll());
        model.addAttribute("Archivos", fileServ.fileListAll());
        return "index";
    }
}
