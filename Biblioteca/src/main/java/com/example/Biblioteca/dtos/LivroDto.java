package com.example.Biblioteca.dtos;

import com.example.Biblioteca.models.Livro;

public record LivroDto(int id, String titulo, String autor, Integer anoPublicacao) {
	
	public LivroDto(Livro livro) {
		this(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao());
	}

	public int id() {
		return id;
	}

	public String titulo() {
		return titulo;
	}

	public String autor() {
		return autor;
	}

	public Integer anoPublicacao() {
		return anoPublicacao;
	}
	
}
