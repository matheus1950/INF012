package com.projeto.Blog.DTO;

import java.util.List;
import java.util.stream.Collectors;

import com.projeto.Blog.models.Categoria;
import com.projeto.Blog.models.Post;

public class PostDto {
 private Long id;
 private String titulo;
 private String texto;
 private String usuario;
 private Categoria categoria;
 
 
 public PostDto(Post post) {
	 this.id = post.getId();
	 this.titulo = post.getTitulo();
	 this.texto = post.getTexto();
	 this.usuario = post.getUsuario().getNome();
	 this.categoria = post.getCategoria();
 }
 
 public static List<PostDto> converte(List<Post> lista){
	 return lista.stream().map(PostDto::new).collect(Collectors.toList());
 }
}
