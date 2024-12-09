package com.projeto.Blog.models;

public class Post {
	
	private Long id;
	private String titulo;
	private String texto;
	private Usuario usuario;
	private Categoria categoria;
	
	public Post() {
		this.titulo = "padrão";
		this.texto = "padrão";
		this.usuario = new Usuario();
		this.categoria = Categoria.ESPORTE;
	}
	
	public Long getId() {
		return id;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", titulo=" + titulo + ", texto=" + texto + ", usuario=" + usuario + ", categoria="
				+ categoria + "]";
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
