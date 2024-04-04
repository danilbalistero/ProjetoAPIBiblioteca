package com.example.demo.service;

import com.example.demo.model.LivroModel;
import com.example.demo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroModel> listarLivros() {
        return livroRepository.findAll();
    }

    public LivroModel criarLivro(LivroModel livro) {
        return livroRepository.save(livro);
    }

    public LivroModel atualizarLivro(Long id, LivroModel livro) {
        return livroRepository.save(livro);
    }

    public boolean deletarLivro(Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return true;
        }
        return false;
    }

}



