package com.example.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Biblioteca.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
}
