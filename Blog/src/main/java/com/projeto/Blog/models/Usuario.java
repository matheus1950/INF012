package com.projeto.Blog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;
	private String login;
	private String senha;
	
	Usuario(){
		this.id = (long) 0;
		this.nome = "Semnome";
		this.login = "Semlogin";
		this.senha = "Semsenha";
	}
	
	public String getNome() {
		return nome;
	}	  
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + "]";
	} 
	
	
}
