package com.projeto.Blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.Blog.DTO.PostDto;
import com.projeto.Blog.models.Post;
import com.projeto.Blog.Repository.PostRepository;

@RestController
public class PostController {
	
	@Autowired
	private PostRepository repository;
	
	@RequestMapping("/posts")
	public List<PostDto> listar(){
		return PostDto.converte(repository.findByTitulo("Dúvida"));
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
		