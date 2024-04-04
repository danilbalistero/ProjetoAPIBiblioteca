package com.example.demo.controller;
import org.springframework.http.HttpStatus;

import com.example.demo.model.FuncionarioModel;
import com.example.demo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioModel> listarFuncionarios() {
        return funcionarioService.listar();
    }

    @PostMapping
    public ResponseEntity<FuncionarioModel> criarFuncionario(@RequestBody FuncionarioModel funcionario) {
        FuncionarioModel novoFuncionario = funcionarioService.criar(funcionario);
        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioModel> atualizarFuncionario(@PathVariable Long id, @RequestBody FuncionarioModel funcionario) {
        FuncionarioModel funcionarioAtualizado = funcionarioService.atualizar(funcionario, id);
        if (funcionarioAtualizado != null) {
            return new ResponseEntity<>(funcionarioAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        if (funcionarioService.deletar(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
