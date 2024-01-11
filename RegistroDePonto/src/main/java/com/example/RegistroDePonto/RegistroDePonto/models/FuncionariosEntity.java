package com.example.RegistroDePonto.RegistroDePonto.models;

import com.example.RegistroDePonto.RegistroDePonto.Enuns.Cargo;
import com.example.RegistroDePonto.RegistroDePonto.Enuns.Estados;
import com.example.RegistroDePonto.RegistroDePonto.Enuns.StatusFuncionario;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class FuncionariosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private String Email;

    @Column(nullable = false)
    private Long telefone;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private int cep;

    @Column(nullable = false)
    private BigDecimal salario;
    @Column(nullable = false)
    private int numero_de_registro;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @Enumerated(EnumType.STRING)
    private Estados estado;

    @Enumerated(EnumType.STRING)
    private StatusFuncionario statusFuncionario;

    public FuncionariosEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "FuncionariosEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
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





