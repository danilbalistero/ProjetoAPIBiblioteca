package com.example.demo.repository;

import com.example.demo.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
}
