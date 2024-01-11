package com.example.RegistroDePonto.RegistroDePonto.controllers;

import com.example.RegistroDePonto.RegistroDePonto.Enuns.Cargo;
import com.example.RegistroDePonto.RegistroDePonto.Enuns.Estados;
import com.example.RegistroDePonto.RegistroDePonto.Enuns.StatusFuncionario;
import com.example.RegistroDePonto.RegistroDePonto.dto.RequisicaoNovoFuncionario;
import com.example.RegistroDePonto.RegistroDePonto.models.FuncionariosEntity;
import com.example.RegistroDePonto.RegistroDePonto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@Valid
public class RelogioControler {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/administrador")
    public ModelAndView findAll() {
        List<FuncionariosEntity> funcionariosEntityList = this.funcionarioRepository.findAll();
        ModelAndView mv = new ModelAndView("administrador/paginaADM");
        mv.addObject("funcionario", funcionariosEntityList);
        return mv;
    }

    @GetMapping("/funcionario")//jogar funcionario para o plural
    public ModelAndView nnew(RequisicaoNovoFuncionario requisicao) {
        ModelAndView mv = new ModelAndView("funcionarios/cadastrarFuncionarios");
        mv.addObject("statusFuncionario", StatusFuncionario.values());
        mv.addObject("cargo", Cargo.values());
        mv.addObject("estado", Estados.values());
        return mv;
    }

/*    @PostMapping("/administrador")
    public ModelAndView create(@Valid RequisicaoNovoFuncionario requisicao, BindingResult bindingResult) {
        System.out.println(requisicao);
        if (bindingResult.hasErrors()) {
            System.out.println("-------------------TEM ERROS--------------------------");
            ModelAndView mv = new ModelAndView("funcionarios/cadastrarFuncionarios");
            mv.addObject("statusFuncionario", StatusFuncionario.values());
            mv.addObject("cargo", Cargo.values());
            mv.addObject("estado", Estados.values());
            return mv;
        } else {
            try {
                FuncionariosEntity funcionarios = requisicao.toFuncionario();
                this.funcionarioRepository.save(funcionarios);
                return new ModelAndView("redirect:/administrador");
            } catch (Exception e) {
                // Lide com a exceção de maneira adequada (pode logar, mostrar mensagem ao usuário, etc.)
                ModelAndView mv = new ModelAndView("funcionarios/cadastrarFuncionarios");
                mv.addObject("statusFuncionario", StatusFuncionario.values());
                mv.addObject("cargo", Cargo.values());
                mv.addObject("estado", Estados.values());
                mv.addObject("error", "Erro ao criar o funcionário.");
                return mv;
            }
        }
    }*/

    @PostMapping("/administrador")
    public ModelAndView create(@Valid RequisicaoNovoFuncionario requisicao, BindingResult bindingResult)  {
        System.out.println(requisicao);
        if(bindingResult.hasErrors()){
            System.out.println("-------------------TEM ERROS--------------------------");
            System.out.println(requisicao);
            ModelAndView mv = new ModelAndView("funcionarios/cadastrarFuncionarios");
            mv.addObject("statusFuncionario", StatusFuncionario.values());
            mv.addObject("cargo", Cargo.values());
            mv.addObject("estado", Estados.values());
            return mv;
        }else {
            FuncionariosEntity funcionariosEntity = requisicao.toFuncionario();
            this.funcionarioRepository.save(funcionariosEntity);
            return new ModelAndView("redirect:/administrador");
        }
    }
}
