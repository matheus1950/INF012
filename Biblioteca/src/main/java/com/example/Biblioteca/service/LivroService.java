package com.example.Biblioteca.service;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.Biblioteca.dtos.LivroDto;
import com.example.Biblioteca.models.Livro;
import com.example.Biblioteca.repository.LivroRepository;

@Service
public class LivroService {
	LivroRepository repositorioLivro;
	
	
	 public ResponseEntity<LivroDto> cadastrar(LivroDto livroDto, UriComponentsBuilder uriBuilder) {
		 	Livro livro = converterDtoParaEntidade(livroDto);
			repositorioLivro.save(livro);
			URI uri= uriBuilder.path("/livro/{id}").buildAndExpand(livro.getId()).toUri();
			return ResponseEntity.created(uri).body(new LivroDto(livro));
	 }
	
	 
	 public Livro converterDtoParaEntidade(LivroDto livroDto) {
		    Livro livro = new Livro();
		    livro.setId(livroDto.id());
		    livro.setTitulo(livroDto.titulo());
		    livro.setAutor(livroDto.autor());
		    livro.setAnoPublicacao(livroDto.anoPublicacao());
		    return livro;
	}
	 
	 
	public List<LivroDto> listarTodos(){
		return repositorioLivro.findAll().stream().map(LivroDto::new).toList();
	}
}
