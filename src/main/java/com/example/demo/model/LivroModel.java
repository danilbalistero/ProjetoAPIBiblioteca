package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
public class LivroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;
    private String autor;
    private String editora;

    private boolean emprestado;

    @ManyToOne
    private FuncionarioModel funcionario;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private ClienteModel cliente;

    public LivroModel() {
    }

    public LivroModel(Long id, String titulo, String autor, String editora, boolean emprestado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.emprestado = emprestado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }
}
