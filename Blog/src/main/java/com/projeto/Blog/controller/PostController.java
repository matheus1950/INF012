package com.projeto.Blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.Blog.DTO.PostDto;
import com.projeto.Blog.models.Post;
import com.projeto.Blog.Repository.PostRepository;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostRepository repository;
	
	//@RequestMapping("/postsTitulo")
	@GetMapping
	public List<PostDto> listar(String titulo){
		return PostDto.converte(repository.findByTitulo(titulo));
	}
	
	//@RequestMapping("/postsUser")
	@GetMapping
	public List<PostDto> listarUser(String nome){
		return PostDto.converte(repository.findByUsuarioNome(nome));
	}
	
	@PostMapping
	public void cadastrar(@RequestBody PostDto postDto) {
		Post post = postDto.converter(repository);
		repository.save(post);
	}
	
	
	
	/*
	@GetMapping("/posts")
	@ResponseBody
	public Post listar() {	
		Post post = new Post();
		post.setTitulo("Titulo de exemplo");
		return post;
	}
	*/
}
		