package com.projeto.Blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.Blog.models.Post;

@RestController
public class PostController {
	
	@GetMapping("/posts")
	@ResponseBody
	public Post listar() {	
		Post post = new Post();
		post.setTitulo("Titulo de exemplo");
		return post;
	}
}
	