package Mingeso.ProjectMilkStgo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping("/planilla_de_pagos")
    public String main(){
        return "planilla_de_pagos";
    }
}
