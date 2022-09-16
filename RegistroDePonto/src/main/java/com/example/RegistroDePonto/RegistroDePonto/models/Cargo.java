package com.example.RegistroDePonto.RegistroDePonto.models;

import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cargo {
    @Id
    private long id;
    @Column(nullable = false)
    private String cargo;


    @OneToMany(mappedBy = "cargo")
    private List<Funcionarios> funcionarios;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


}
