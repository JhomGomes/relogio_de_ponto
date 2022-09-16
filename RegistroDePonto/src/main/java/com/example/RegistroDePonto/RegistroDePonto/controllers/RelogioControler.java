package com.example.RegistroDePonto.RegistroDePonto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RelogioControler {

    @GetMapping("/RelogioDePonto")
    public String relogioDePonto() {
        return "Front-End/RelogioDePonto";
    }

    @GetMapping("/PaginaEntrada")
    public String paginaEntrada(){
        return "Front-End/PaginaEntrada";
    }

    @GetMapping("/saida")
    public String Saida(){
        return "Front-End/Saida";
    }


}
