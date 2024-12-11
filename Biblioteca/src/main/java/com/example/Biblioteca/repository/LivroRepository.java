package com.example.Biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Biblioteca.models.Livro;


public interface LivroRepository extends JpaRepository<Livro, Long>{
	public List<Livro> listarTodos();
	public void adicionarLivro(Livro livro);
	public void atualizarLivro(int id);
	public void deleteLivro(int id);
}
