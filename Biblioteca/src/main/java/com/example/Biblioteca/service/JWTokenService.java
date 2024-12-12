package com.example.Biblioteca.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.example.Biblioteca.models.Usuario;

@Service
public class JWTokenService {

		 
	public String gerarToken(Usuario usuario) {
 
		try {
			var algoritmo = Algorithm.HMAC256(secret);
			
			return JWT.create()
			.withIssuer("Aula de PWEB")
			.withSubject(usuario.getUsername())
			.withExpiresAt(dataExpiracao())
			.sign(algoritmo);
			} catch (JWTCreationException exception){
				throw new RuntimeException("erro ao gerrar token jwt", exception);
		}        
	}
 
	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
		  
	
}
