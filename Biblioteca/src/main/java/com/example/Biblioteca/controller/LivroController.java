package com.example.Biblioteca.controller;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.Biblioteca.dtos.LivroDto;
import com.example.Biblioteca.models.Livro;
import com.example.Biblioteca.service.LivroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {
	private LivroService livroService;
	
	@GetMapping
	@Secured("ROLE_USER")
	public List<LivroDto> listarTodos(){
		return livroService.listarTodos();
	}
	
	@PostMapping
	@Secured("ROLE_ADMIN")
	public void adicionarLivro(@RequestBody @Valid LivroDto livroDto, UriComponentsBuilder uriBuilder) {
		livroService.cadastrar(livroDto, uriBuilder);
	}
	
	@DeleteMapping
	@Secured("ROLE_ADMIN")
	public void deletarLivro(Long id) {
		livroService.deletar(id);
	}
	
	@PutMapping
	@Secured("ROLE_ADMIN")
	public void atualizarLivro(LivroDto livroDto, Long id) {
		livroService.atualizar(livroDto, id);
	}
}
