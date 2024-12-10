package com.example.Pets.Dtos;

import com.example.Pets.models.Cliente;
import com.example.Pets.repository.ClienteRepository;

import jakarta.validation.constraints.NotNull;


public class ClienteDto {
	@NotNull
	private int id;
	@NotNull
	private String nome;
	@NotNull
	private String email;
	@NotNull
	private	String telefone;
	@NotNull
	private String endereco;
	
	
	public ClienteDto(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();
		this.endereco = cliente.getEndereco();
	}

	
	public void cadastrar(String nome, String email, String telefone, String endereco) {
		
	}
	
	public Cliente converter(ClienteRepository clienteRepository) {
			Cliente cliente = clienteRepository.findById(id);
			
			return cliente;
	}
}
