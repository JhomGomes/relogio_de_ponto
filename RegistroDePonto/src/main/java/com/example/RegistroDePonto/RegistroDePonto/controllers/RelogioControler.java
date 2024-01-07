package com.example.RegistroDePonto.RegistroDePonto.controllers;

import com.example.RegistroDePonto.RegistroDePonto.Enuns.StatusFuncionario;
import com.example.RegistroDePonto.RegistroDePonto.models.Funcionarios;
import com.example.RegistroDePonto.RegistroDePonto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RelogioControler {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/administrador")
    public ModelAndView findAll() {
        System.out.println("-------------");
        List<Funcionarios> funcionariosList = this.funcionarioRepository.findAll();
        ModelAndView mv = new ModelAndView("administrador/paginaADM");
        mv.addObject("funcionario", funcionariosList);
        return mv;
    }

    @GetMapping("/funcionario")
    public ModelAndView nnew(){
        ModelAndView mv = new ModelAndView("funcionarios/cadastrarFuncionarios");
        mv.addObject("statusFuncionario", StatusFuncionario.values());
        return mv;
    }
}
