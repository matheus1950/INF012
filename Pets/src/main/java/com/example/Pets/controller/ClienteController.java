package com.example.Pets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pets.Dtos.ClienteDto;
import com.example.Pets.models.Cliente;
import com.example.Pets.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping
	public List<Cliente> listarTodos(int id){
		return repository.findAll();
	}
	
	
	@PostMapping
	public void cadastrar(@RequestBody ClienteDto clienteDto) {
		Cliente cliente = clienteDto.converter(repository);
		repository.save(cliente);
	}
	
	
}
