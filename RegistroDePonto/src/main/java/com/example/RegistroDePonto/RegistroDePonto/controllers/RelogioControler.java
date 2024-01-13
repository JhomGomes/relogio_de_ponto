package com.example.RegistroDePonto.RegistroDePonto.controllers;

import com.example.RegistroDePonto.RegistroDePonto.Enuns.Cargo;
import com.example.RegistroDePonto.RegistroDePonto.Enuns.Estados;
import com.example.RegistroDePonto.RegistroDePonto.Enuns.StatusFuncionario;
import com.example.RegistroDePonto.RegistroDePonto.dto.RequisicaoFuncionario;
import com.example.RegistroDePonto.RegistroDePonto.models.FuncionariosEntity;
import com.example.RegistroDePonto.RegistroDePonto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/funcionarios")//jogar funcionario para o plural
    public ModelAndView nnew(RequisicaoFuncionario requisicao) {
        ModelAndView mv = new ModelAndView("funcionarios/cadastrarFuncionarios");
        mv.addObject("statusFuncionario", StatusFuncionario.values());
        mv.addObject("cargo", Cargo.values());
        mv.addObject("estado", Estados.values());
        return mv;
    }

    @PostMapping("/administrador")
    public ModelAndView create(@Valid RequisicaoFuncionario requisicao, BindingResult bindingResult)  {
        if(bindingResult.hasErrors()){
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

    @GetMapping("/administrador/{id}")
    public ModelAndView show(@PathVariable Long id, RequisicaoFuncionario requisicao, BindingResult bindingResult){
        Optional<FuncionariosEntity> optional = this.funcionarioRepository.findById(id);

        if(optional.isPresent()){
            FuncionariosEntity funcionario = optional.get();
            ModelAndView mv = new ModelAndView("detalhes/detalhes");
            mv.addObject("funcionario", funcionario);
            mv.addObject("statusFuncionario", StatusFuncionario.values());
            mv.addObject("cargo", Cargo.values());
            mv.addObject("estado", Estados.values());
            return mv;
        }else{
            return new ModelAndView("redirect:/administrador"); //fazer uma tratativa para quando nao achar
        }
    }

    @GetMapping("/administrador/{id}/editar")
    public ModelAndView edit(@PathVariable Long id, RequisicaoFuncionario requisicao, BindingResult bindingResult){
        Optional<FuncionariosEntity> optional = this.funcionarioRepository.findById(id);

        if(optional.isPresent()){
            FuncionariosEntity funcionarios = optional.get();
            requisicao.fromFuncionario(funcionarios);

            ModelAndView mv = new ModelAndView("editar/editar");
            mv.addObject("funcionariosId", funcionarios.getId());
            mv.addObject("funcionario", funcionarios);
            mv.addObject("statusFuncionario", StatusFuncionario.values());
            mv.addObject("cargo", Cargo.values());
            mv.addObject("estado", Estados.values());
            return mv;
        }else{
            return new ModelAndView("redirect:/administrador"); //fazer uma tratativa para quando nao achar
        }

    }
}
