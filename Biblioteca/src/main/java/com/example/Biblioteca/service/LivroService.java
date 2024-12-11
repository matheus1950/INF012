package com.example.Biblioteca.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Biblioteca.dtos.LivroDto;
import com.example.Biblioteca.models.Livro;
import com.example.Biblioteca.repository.LivroRepository;

@Service
public class LivroService {
	LivroRepository repositorioLivro;
	
	
	 public void cadastrar(@RequestBody LivroDto livroDto) {
		 
		// repositorioLivro.save(livroDto);
	 }
	
}
