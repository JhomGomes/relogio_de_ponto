package com.example.RegistroDePonto.RegistroDePonto.dto;

import com.example.RegistroDePonto.RegistroDePonto.Enuns.Cargo;
import com.example.RegistroDePonto.RegistroDePonto.Enuns.Estados;
import com.example.RegistroDePonto.RegistroDePonto.Enuns.StatusFuncionario;
import com.example.RegistroDePonto.RegistroDePonto.models.Funcionarios;

import java.math.BigDecimal;


public class RequisicaoNovoFuncionario {

    private String nome;

    private String sobrenome;

    private String Email;

    private Long telefone;

    private String endereco;

    private String cidade;

    private int cep;

    private int numero_de_registro;


    private Estados estado;

    private StatusFuncionario statusFuncionario;

    private Cargo cargo;

    private BigDecimal salario;

    public Funcionarios toFuncionario() {
        Funcionarios funcionarios = new Funcionarios();
        funcionarios.setNome(this.nome);
        funcionarios.setSobrenome(this.sobrenome);
        funcionarios.setEmail(this.Email);
        funcionarios.setTelefone(this.telefone);
        funcionarios.setEndereco(this.endereco);
        funcionarios.setCidade(this.cidade);
        funcionarios.setCep(this.cep);
        funcionarios.setNumero_de_registro(this.numero_de_registro);
        funcionarios.setEstado(this.estado);
        funcionarios.setStatusFuncionario(this.statusFuncionario);
        funcionarios.setCargo(this.cargo);
        funcionarios.setSalario(this.salario);

        return funcionarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public StatusFuncionario getStatusFuncionario() {
        return statusFuncionario;
    }

    public void setStatusFuncionario(StatusFuncionario statusFuncionario) {
        this.statusFuncionario = statusFuncionario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNumero_de_registro() {
        return numero_de_registro;
    }

    public void setNumero_de_registro(int numero_de_registro) {
        this.numero_de_registro = numero_de_registro;
    }

    @Override
    public String toString() {
        return "RequisicaoNovoFuncionario{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", Email='" + Email + '\'' +
                ", telefone=" + telefone +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", cep=" + cep +
                ", numero_de_registro=" + numero_de_registro +
                ", estado=" + estado +
                ", statusFuncionario=" + statusFuncionario +
                ", cargo=" + cargo +
                ", salario=" + salario +
                '}';
    }
}
