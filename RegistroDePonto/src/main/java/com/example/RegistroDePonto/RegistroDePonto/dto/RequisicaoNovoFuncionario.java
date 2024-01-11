package com.example.RegistroDePonto.RegistroDePonto.dto;

import com.example.RegistroDePonto.RegistroDePonto.Enuns.Cargo;
import com.example.RegistroDePonto.RegistroDePonto.Enuns.Estados;
import com.example.RegistroDePonto.RegistroDePonto.Enuns.StatusFuncionario;
import com.example.RegistroDePonto.RegistroDePonto.models.Funcionarios;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RequisicaoNovoFuncionario {

    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String sobrenome;

    @NotBlank
    @NotEmpty
    @javax.validation.constraints.Email
    private String Email;

    @NotNull
    @NotEmpty
    private Long telefone;

    @NotBlank
    @NotEmpty
    private String endereco;

    @NotBlank
    @NotEmpty
    private String cidade;

    /*@NotNull
    @NotEmpty*/
    //@DecimalMin(value = "0.01", inclusive = false)
    @NotNull
    @NotEmpty
    private int cep;

    @NotNull
    private int numero_de_registro;

    private Estados estado;

    private StatusFuncionario statusFuncionario;

    private Cargo cargo;

    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal salario;

/*    public Funcionarios toFuncionario() {

        if (telefone == null && !nome.isEmpty()  && nome == null && sobrenome == null && salario == null) {
            throw new IllegalArgumentException("Campos obrigatórios não podem ser nulos.");
        }

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
    }*/

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
