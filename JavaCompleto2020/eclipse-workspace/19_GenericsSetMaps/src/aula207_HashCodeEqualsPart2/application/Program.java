package aula207_HashCodeEqualsPart2.application;

import aula207_HashCodeEqualsPart2.entities.Client;

public class Program {

	public static void main(String[] args) {
		
		//Foi gerado na classe Client um metodo hashCode e equals de modo a comparar com o nome e email
		//Botão Direito - Source - Generate HashCode() and Equals()... - Selecionar os que se pretende comparar
		
		Client c1 = new Client("Maria", "maria@gmail.com");
		Client c2 = new Client("Maria", "maria@gmail.com");
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c1.equals(c2));
		
		System.out.println(c1 == c2); //retorna falso porque as posicoes de memoria sao diferentes, mesmo que sejam iguais
		String s1 = "Test"; String s2 = "Test"; System.out.println(s1 == s2); //aqui retorna true porque o compilador trata a funcao literal de outra forma
		
		String a = "Mike";
		String m = "Mike";
		System.out.println("Resultado: " + a.equals(m)); //Resultado é true
	}

}
