package com.example.Biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	@Autowired
	private LivroService livroService;
	
	//@Secured("ROLE_USER")
	@GetMapping
	public List<LivroDto> listarTodos(){
		return livroService.listarTodos();
	}
	
	@PostMapping
	@Secured("ROLE_ADMIN")
	public void adicionarLivro(@RequestBody @Valid LivroDto livroDto, UriComponentsBuilder uriBuilder) {
		livroService.cadastrar(livroDto, uriBuilder);
	}
	
	@DeleteMapping("/{id}")
	@Secured("ROLE_ADMIN")
	public void deletarLivro(@PathVariable Long id) {
		livroService.deletar(id);
	}
	
	@PutMapping("/{id}")
	@Secured("ROLE_ADMIN")
	public void atualizarLivro(@RequestBody LivroDto livroDto, @PathVariable Long id) {
		livroService.atualizar(livroDto, id);
	}
}
