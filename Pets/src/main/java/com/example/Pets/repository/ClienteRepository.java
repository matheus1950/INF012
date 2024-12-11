package com.example.Pets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.Pets.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	public Cliente findById(int id);
	@Query("SELECT * FROM cliente")
	public List<Cliente> findAll();
	@Query("UPDATE cliente SET nome = ? email = ? endereco = ? telefone = ? WHERE id = ?")
	public void atualizarClienteById(int id);
	public void deleteClienteById(int id);
	
}
