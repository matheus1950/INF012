package com.projeto.Blog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.Blog.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public List<Usuario> findByNome(String nome);
}
