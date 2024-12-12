package com.example.Biblioteca.dtos;

import java.util.List;

import com.example.Biblioteca.models.Role;
import com.example.Biblioteca.models.Usuario;

public record UsuarioDto(int id, String username, String password, Role role) {
	
	public UsuarioDto(Usuario usuario) {
        this(usuario.getId(), usuario.getUsername(), usuario.getPassword(), usuario.getRole());
    }
	
	
}

