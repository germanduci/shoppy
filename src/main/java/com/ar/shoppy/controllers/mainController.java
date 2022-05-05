package com.ar.shoppy.controllers;

import com.ar.shoppy.services.clientService;
import com.ar.shoppy.services.fileService;
import com.ar.shoppy.services.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
}
