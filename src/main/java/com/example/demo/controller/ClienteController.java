package com.example.demo.controller;

import com.example.demo.model.ClienteModel;
import com.example.demo.model.LivroModel;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public List<ClienteModel> listarClientes() {
        return clienteService.listar();
    }

    @PostMapping
    public ResponseEntity<ClienteModel> criarCliente(@RequestBody ClienteModel cliente) {
        ClienteModel novoCliente = clienteService.criar(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizarCliente(@PathVariable Long id, @RequestBody ClienteModel cliente) {
        ClienteModel clienteAtualizado = clienteService.atualizar(cliente, id);
        if (clienteAtualizado != null) {
            return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        if (clienteService.deletar(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{clienteId}/emprestarLivro/{livroId}")
    public ResponseEntity<String> emprestarLivro(@PathVariable ClienteModel clienteId, @PathVariable LivroModel livroId) {
        boolean emprestado = clienteService.emprestarLivro(clienteId, livroId);
        if (emprestado) {
            return ResponseEntity.ok("Livro emprestado com sucesso!");
        } else {
            return ResponseEntity.badRequest().body("Falha ao emprestar o livro. Verifique os dados fornecidos.");
        }
    }

    @PutMapping("/{clienteId}/devolverLivro/{livroId}")
    public ResponseEntity<String> devolverLivro(@PathVariable ClienteModel clienteId, @PathVariable LivroModel livroId) {
        boolean devolvido = clienteService.devolverLivro(clienteId, livroId);
        if (devolvido) {
            return ResponseEntity.ok("Livro devolvido com sucesso!");
        } else {
            return ResponseEntity.badRequest().body("Falha ao devolver o livro. Verifique os dados fornecidos.");
        }
    }

}
