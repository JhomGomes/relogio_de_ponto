package com.example.RegistroDePonto.RegistroDePonto.controllers;

import com.example.RegistroDePonto.RegistroDePonto.Enuns.Cargo;
import com.example.RegistroDePonto.RegistroDePonto.Enuns.Estados;
import com.example.RegistroDePonto.RegistroDePonto.Enuns.StatusFuncionario;
import com.example.RegistroDePonto.RegistroDePonto.dto.RequisicaoFuncionario;
import com.example.RegistroDePonto.RegistroDePonto.models.FuncionariosEntity;
import com.example.RegistroDePonto.RegistroDePonto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.dao.EmptyResultDataAccessException;
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

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("login/paginaLogin");
        return mv;
    }

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

    @GetMapping("/administrador/next")
    public String getPagina(@RequestParam long id) {
        // Lógica para carregar os registros da página
        //List<Funcionario> funcionarios = carregarRegistrosDaPagina(pagina);

        // Adiciona os funcionários ao modelo
        //model.addAttribute("funcionarios", funcionarios);

        return "administrador/paginaADM";
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

    @PostMapping("/administrador/{id}")
    public ModelAndView update(@PathVariable Long id, RequisicaoFuncionario requisicao, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("editar/editar");
            mv.addObject("statusFuncionario", StatusFuncionario.values());
            mv.addObject("cargo", Cargo.values());
            mv.addObject("estado", Estados.values());
            return mv;
        }else {
            Optional<FuncionariosEntity> optional = this.funcionarioRepository.findById(id);

            if (optional.isPresent()){
                FuncionariosEntity funcionario = requisicao.toFuncionarioEntity(optional.get());
                this.funcionarioRepository.save(funcionario);
                return new ModelAndView("redirect:/administrador/{id}");
            }else {
                return new ModelAndView("redirect:/editar/editar"); //fazer uma tratativa para quando nao achar
            }
        }
    }

    @GetMapping("/administrador/{id}/delete")
    public String delete(@PathVariable Long id) {
        try {
            this.funcionarioRepository.deleteById(id);
            return "redirect:/administrador";
        }catch (EmptyResultDataAccessException e){
            System.out.println(e);
            return "redirect:/administrador";
        }
    }
}
