package com.example.Biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.Biblioteca.repository")
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);

		/*
		 	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        String senhaCriptografada = encoder.encode("123");
	        System.out.println("Senha criptografada: " + senhaCriptografada);
	        */
	}

}
