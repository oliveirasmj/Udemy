package com.example._ProjetoSpring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example._ProjetoSpring.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource { //classe que disponibiliza um recurso relativamente aos usuarios
	
	@GetMapping
	public ResponseEntity<User> findAll(){ //metodo para aceder aos usuarios (ResponseEntity - respostas de requisicoes Web)
		User u = new User(1L, "Maria", "maria@gmail.com", "999999999", "12345");
		return ResponseEntity.ok().body(u); //retornar a resposta
	}
}
