package com.projeto.Blog.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto.Blog.DTO.PostDto;
import com.projeto.Blog.models.Post;

import jakarta.validation.Valid;

import com.projeto.Blog.Repository.PostRepository;
import com.projeto.Blog.Repository.UsuarioRepository;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
    private UsuarioRepository userRepository;
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
		return PostDto.converter(repository.findByUsuarioNome(nome));
	}
	
	@PostMapping
	public ResponseEntity<PostDto> cadastrar(@RequestBody @Valid PostDto postDto, UriComponentsBuilder uriBuilder) {
		Post post= postDto.converter(userRepository);
		 repository.save(post);
		 URI uri = uriBuilder.path("/posts/{id}").buildAndExpand(post.getId()).toUri();
		 return ResponseEntity.created(uri).body(new PostDto(post));
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
		