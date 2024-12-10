package com.example.Pets.Dtos;

import com.example.Pets.Categoria;

import jakarta.validation.constraints.NotNull;

public class ProdutoDto {
	@NotNull
	private int id;
	private String nome;
	private String descricao;
	private double preco;
	private int qtdEstoque;
	private Categoria categoria;
	
	
}
