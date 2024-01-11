package com.example.RegistroDePonto.RegistroDePonto.dto;

import com.example.RegistroDePonto.RegistroDePonto.Enuns.Cargo;
import com.example.RegistroDePonto.RegistroDePonto.Enuns.Estados;
import com.example.RegistroDePonto.RegistroDePonto.Enuns.StatusFuncionario;
import com.example.RegistroDePonto.RegistroDePonto.models.FuncionariosEntity;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class RequisicaoNovoFuncionario {

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @javax.validation.constraints.Email
    private String Email;

    @NotNull
    private Long telefone;

    @NotBlank
    private String endereco;

    @NotBlank
    private String cidade;

    @NotNull
    @Positive
    private int cep;

    @NotNull
    @DecimalMin(value="0.0")
    private BigDecimal salario;
    @NotNull
    @Positive
    private int numero_de_registro;

    private Cargo cargo;

    private Estados estado;

    private StatusFuncionario statusFuncionario;


    public FuncionariosEntity toFuncionario() {
        FuncionariosEntity funcionariosEntity = new FuncionariosEntity();
        funcionariosEntity.setNome(this.nome);
        funcionariosEntity.setSobrenome(this.sobrenome);
        funcionariosEntity.setEmail(this.Email);
        funcionariosEntity.setTelefone(this.telefone);
        funcionariosEntity.setEndereco(this.endereco);
        funcionariosEntity.setCidade(this.cidade);
        funcionariosEntity.setCep(this.cep);
        funcionariosEntity.setNumero_de_registro(this.numero_de_registro);
        funcionariosEntity.setEstado(this.estado);
        funcionariosEntity.setStatusFuncionario(this.statusFuncionario);
        funcionariosEntity.setCargo(this.cargo);
        funcionariosEntity.setSalario(this.salario);

        return funcionariosEntity;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public int getNumero_de_registro() {
        return numero_de_registro;
    }

    public void setNumero_de_registro(int numero_de_registro) {
        this.numero_de_registro = numero_de_registro;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
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
                ", salario=" + salario +
                ", numero_de_registro=" + numero_de_registro +
                ", cargo=" + cargo +
                ", estado=" + estado +
                ", statusFuncionario=" + statusFuncionario +
                '}';
    }
}
