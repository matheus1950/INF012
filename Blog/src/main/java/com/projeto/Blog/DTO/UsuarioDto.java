package com.projeto.Blog.DTO;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioDto {
	private Long id;
	@NotNull(message = "O nome não pode ser nulo")
    private String nome;
	@NotBlank(message = "O login não pode ser vazio")
	@Length(min=5,message = "O login tem min de 5 caractres")
	private String login;
	private String senha;
}
