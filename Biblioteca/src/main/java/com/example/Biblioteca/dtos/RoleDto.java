package com.example.Biblioteca.dtos;

import com.example.Biblioteca.models.Role;

public record RoleDto(Long id, String role) {
	
	public RoleDto(Role role) {
		this(role.getId(), role.getRole());
	}
	

	public Long id() {
		return id;
	}

	public String role() {
		return role;
	}
	
}
