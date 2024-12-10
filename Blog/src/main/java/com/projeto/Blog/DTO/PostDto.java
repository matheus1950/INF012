package com.projeto.Blog.DTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.Blog.Repository.PostRepository;
import com.projeto.Blog.Repository.UsuarioRepository;
import com.projeto.Blog.models.Categoria;
import com.projeto.Blog.models.Post;
import com.projeto.Blog.models.Usuario;

import jakarta.validation.constraints.NotNull;

public class PostDto {
	private Long id;
	private String titulo;
	private String texto;
	private String usuario;
	private Categoria categoria;
	@Autowired
	private UsuarioRepository userRepository;
 
	public PostDto(Post post) {
		 this.id = post.getId();
		 this.titulo = post.getTitulo();
		 this.texto = post.getTexto();
		 this.usuario = post.getUsuario().getNome();
		 this.categoria = post.getCategoria();
	}
 
	 public Post converter(String nome) {
		 Usuario user = userRepository.findByNome(usuario);
		 Post post = new Post(titulo, texto, user );
		 return post;
	 }
 
	 public static List<PostDto> converte(List<Post> lista){
		 return lista.stream().map(PostDto::new).collect(Collectors.toList());
	 }
}
