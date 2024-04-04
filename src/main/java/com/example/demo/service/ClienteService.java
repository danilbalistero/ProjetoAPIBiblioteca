package com.example.demo.service;

import com.example.demo.model.ClienteModel;
import com.example.demo.model.LivroModel;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements PessoaService<ClienteModel> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteModel> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteModel criar(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public ClienteModel atualizar(ClienteModel cliente, Long id) {
        if (clienteRepository.existsById(id)) {
            cliente.setClienteId(id);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    @Override
    public boolean deletar(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public boolean emprestarLivro(ClienteModel cliente, LivroModel livro) {
        if (!livro.isEmprestado()) {
            livro.setEmprestado(true);
            cliente.addLivroEmprestado(livro);
            clienteRepository.save(cliente);
            return true;
        } else {
            return false;
        }
    }

    public boolean devolverLivro(ClienteModel cliente, LivroModel livro) {
        if (livro.isEmprestado() && cliente.getLivrosEmprestados().contains(livro)) {
            livro.setEmprestado(false);
            cliente.removeLivroEmprestado(livro);
            clienteRepository.save(cliente);
            return true;
        } else {

            return false;
        }
    }


}
