package com.example.RegistroDePonto.RegistroDePonto.models;

import com.example.RegistroDePonto.RegistroDePonto.Enuns.StatusFuncionario;

import javax.persistence.*;

@Entity
public class Funcionarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double salario;

    @ManyToOne
    @JoinColumn(name = "cargo", nullable = false)
    private Cargo cargo;

    @Enumerated(EnumType.STRING)
    private StatusFuncionario statusFuncionario;

    public Funcionarios() {}

    public void setStatusFuncionario(StatusFuncionario statusFuncionario) {
        this.statusFuncionario = statusFuncionario;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public StatusFuncionario getStatusFuncionario() {
        return statusFuncionario;
    }
}





