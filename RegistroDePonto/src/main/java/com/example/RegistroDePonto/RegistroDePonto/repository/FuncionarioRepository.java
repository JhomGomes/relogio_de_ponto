package com.example.RegistroDePonto.RegistroDePonto.repository;

import com.example.RegistroDePonto.RegistroDePonto.models.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionarios, Long> {

}
