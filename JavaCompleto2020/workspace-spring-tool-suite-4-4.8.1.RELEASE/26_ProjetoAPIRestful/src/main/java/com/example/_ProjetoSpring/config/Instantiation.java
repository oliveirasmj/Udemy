package com.example._ProjetoSpring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example._ProjetoSpring.domain.User;
import com.example._ProjetoSpring.repository.UserRepository;

@Configuration //classe de configuracao
public class Instantiation implements CommandLineRunner { //CLASSE APENAS DEFINIR ALGUNS REGISTOS AO JNICIAR

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll(); //apagar todos os que estao na BD
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob)); //adicionar à BD
	}

}
