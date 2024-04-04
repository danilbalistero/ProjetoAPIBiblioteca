package com.example.demo.controller;
import com.example.demo.model.LivroModel;
import com.example.demo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<LivroModel> listarLivros() {
        return livroService.listarLivros();
    }

    @PostMapping
    public ResponseEntity<LivroModel> criarLivro(@RequestBody LivroModel livro) {
        LivroModel novoLivro = livroService.criarLivro(livro);
        return new ResponseEntity<>(novoLivro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroModel> atualizarLivro(@PathVariable Long id, @RequestBody LivroModel livro) {
        LivroModel livroAtualizado = livroService.atualizarLivro(id, livro);
        if (livroAtualizado != null) {
            return new ResponseEntity<>(livroAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        if (livroService.deletarLivro(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}
