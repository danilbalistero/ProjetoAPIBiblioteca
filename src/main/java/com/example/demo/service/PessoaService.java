package com.example.demo.service;

import com.example.demo.model.Pessoa;

import java.util.List;

public interface PessoaService<T extends Pessoa> {
    List<T> listar();
    T criar(T t);
    T atualizar(T t, Long id);
    boolean deletar(Long id);
}
