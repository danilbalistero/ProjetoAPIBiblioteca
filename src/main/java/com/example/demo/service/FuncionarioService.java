package com.example.demo.service;

import com.example.demo.model.FuncionarioModel;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService implements PessoaService<FuncionarioModel> {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<FuncionarioModel> listar() {
        return funcionarioRepository.findAll();
    }

    @Override
    public FuncionarioModel criar(FuncionarioModel funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public FuncionarioModel atualizar(FuncionarioModel funcionario, Long id) {
        if (funcionarioRepository.existsById(id)) {
            funcionario.setFuncionarioId(id);
            return funcionarioRepository.save(funcionario);
        }
        return null;
    }

    @Override
    public boolean deletar(Long id) {
        if (funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
