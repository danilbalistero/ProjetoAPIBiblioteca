package com.example.demo.repository;

import com.example.demo.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
    List<LivroModel> findByTituloContains(String titulo);
}
