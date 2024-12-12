package com.example.Biblioteca.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.repository.LivroRepository;

@Service
public class AutenticacaoService implements UserDetailsService{

	
	private LivroRepository livroRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		return this.livroRepository.findByLogin(username);
	}
	
}
