package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@JsonPropertyOrder({"clienteId","nome","telefone","email"})
@Entity
public class ClienteModel extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    private String endereco;
    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    private List<LivroModel> livrosEmprestados = new ArrayList<>();

    public ClienteModel() {
    }

    public ClienteModel(String nome, String telefone, String email, Long clienteId, String endereco, List<LivroModel> livrosEmprestados) {
        super(nome, telefone, email);
        this.clienteId = clienteId;
        this.endereco = endereco;
        this.livrosEmprestados = livrosEmprestados;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<LivroModel> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(List<LivroModel> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }

    public void addLivroEmprestado(LivroModel livro) {
        this.livrosEmprestados.add(livro);
        livro.setCliente(this);
    }

    public void removeLivroEmprestado(LivroModel livro) {
        this.livrosEmprestados.remove(livro);
        livro.setCliente(null);
    }

}
