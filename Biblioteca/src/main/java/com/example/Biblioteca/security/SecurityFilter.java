package com.example.Biblioteca.security;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.Biblioteca.repository.UsuarioRepository;
import com.example.Biblioteca.service.JWTokenService;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/api/**")
@Component
public class SecurityFilter implements Filter{
	@Autowired
	private JWTokenService tokenService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	 protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain 
	filterChain) throws ServletException, IOException {
		 var token = recuperarToken(request);
		 System.out.println("Token: " + token);
		 if(token!=null) {
			 var login = tokenService.getSubject(token);
			 var usuario = usuarioRepository.findByUsername(login);
			 var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
			 SecurityContextHolder.getContext().setAuthentication(authentication);
		 }
		 filterChain.doFilter(request, response);
	 }
	 
	 public String recuperarToken(HttpServletRequest request) {
		 var token = request.getHeader("Authorization");
		        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
		            return null;
		        }
		        return token.replace("Bearer ", "");
	}

	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("Requisição recebida em: " + LocalDateTime.now());
		filterChain.doFilter(servletRequest, servletResponse);
	}
	

}
