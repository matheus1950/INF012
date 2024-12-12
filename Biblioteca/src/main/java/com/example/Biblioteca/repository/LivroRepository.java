package com.example.Biblioteca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.Biblioteca.models.Livro;


public interface LivroRepository extends JpaRepository<Livro, Long>{
	public UserDetails findByLogin(String username);
}
