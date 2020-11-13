package com.example._ProjetoSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example._ProjetoSpring.entities.User;
import com.example._ProjetoSpring.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource { //classe que disponibiliza um recurso relativamente aos Users - por HTTP - METODO QUE DEVOLVE O QUE É PEDIDO NA URL
	
	@Autowired
	private UserService service; //classe para pesquisar na BD
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){ //metodo para aceder aos usuarios (ResponseEntity - respostas de requisicoes Web)
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); //retornar a resposta
	}
	
	@GetMapping(value = "/{id}") //agora é passado um id pela url
	public ResponseEntity<User> findById(@PathVariable Long id) { //metodo para aceder ao usuario por id
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
