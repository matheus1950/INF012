package com.example.Biblioteca.models;

import org.springframework.security.core.GrantedAuthority;

import com.example.Biblioteca.dtos.RoleDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity(name = "roles")		
public class Role implements GrantedAuthority{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String role;	
		
	public Role() {
	
	}

	public Role(RoleDto roleDto) {
		super();
		this.id = roleDto.id();
		this.role = roleDto.role();
	}


	@Override
	public String getAuthority() {
		return this.role;	
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
}
