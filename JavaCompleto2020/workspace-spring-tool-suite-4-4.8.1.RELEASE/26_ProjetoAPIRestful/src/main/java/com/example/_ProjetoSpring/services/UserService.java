package com.example._ProjetoSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example._ProjetoSpring.domain.User;
import com.example._ProjetoSpring.repository.UserRepository;

//Classe que faz a ligação a Dados

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo; //o Serviço acede ao Repository
	
	public List<User> findAll(){
		return repo.findAll(); //metodo que retorna todos os objetos na BD do tipo User
	}
}
