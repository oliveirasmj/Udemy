package com.example._ProjetoSpring.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example._ProjetoSpring.domain.User;
import com.example._ProjetoSpring.services.UserService;

@RestController //indicar qual vai ser um recurso rest
@RequestMapping(value = "/users") //indicar o caminho do endpoint
public class UserResource {
	
	@Autowired
	private UserService service; //Resource(Controlador) vai aceder ao Serviço e o Serviço acede ao Repository
	
	@RequestMapping(method = RequestMethod.GET) //este metodo vai ser um endpoint no caminho /users      OU    @GetMapping
	public ResponseEntity<List<User>> findAll(){ //metodo para retornar lista de users MAS dentro de um ResponseEntity (retornar HTTP com cabeçalhos e erros)
		
		List<User> list = service.findAll(); //ir buscar os dados à BD
		
		return ResponseEntity.ok().body(list); //retornar list dentro de ResponseEntity no seu body
	}
}




//@RequestMapping(method = RequestMethod.GET) //este metodo vai ser um endpoint no caminho /users      OU    @GetMapping
//public List<User> findAll(){ //metodo para retornar lista de users
//	User maria = new User("1", "Maria Brown", "maria@gmail.com");
//	User alex = new User("2", "Alex Green", "alex@gmail.com");
//	
//	List<User> list = new ArrayList<>();
//	list.addAll(Arrays.asList(maria, alex));
//	
//	return list;
//}
