package com.example.Biblioteca.dtos;

import java.util.List;

import com.example.Biblioteca.models.Role;
import com.example.Biblioteca.models.Usuario;

public record UsuarioDto(int id, String username, String password, List<RoleDto> role) {
	
	public UsuarioDto(Usuario usuario) {
        this(usuario.getId(), usuario.getUsername(), usuario.getPassword(), usuario.getRoles().stream().map(RoleDto::new).toList());
    }

	public int id() {
		return id;
	}

	public String username() {
		return username;
	}

	public String password() {
		return password;
	}

	public List<RoleDto> role() {
		return role;
	}
	
	
}

