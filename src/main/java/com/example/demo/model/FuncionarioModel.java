package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonPropertyOrder({"funcionarioId","nome","telefone","email"})
@Entity
public class FuncionarioModel extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcionarioId;

    private double salario;


    public FuncionarioModel() {
    }

    public FuncionarioModel(String nome, String telefone, String email, Long funcionarioId, double salario) {
        super(nome, telefone, email);
        this.funcionarioId = funcionarioId;
        this.salario = salario;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
