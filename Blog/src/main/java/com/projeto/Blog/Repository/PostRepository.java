package com.projeto.Blog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.Blog.models.Post;

public interface PostRepository  extends JpaRepository<Post,Long>{
	public List<Post> findByTitulo(String titulo);
}
