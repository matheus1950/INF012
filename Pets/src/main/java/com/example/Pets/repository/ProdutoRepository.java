package com.example.Pets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Pets.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	public void cadastrar();
	public List<Produto> findAll();
	public List<Produto> findByCategoria();
	public void updateProdutoById(int id);
	public void deleteProdutoById(int id);
}
