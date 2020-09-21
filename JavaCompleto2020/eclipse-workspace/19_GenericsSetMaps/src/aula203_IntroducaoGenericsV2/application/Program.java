package aula203_IntroducaoGenericsV2.application;

import java.util.Scanner;

import aula203_IntroducaoGenericsV2.services.PrintService;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		PrintService ps = new PrintService(); //agora é do tipo object - adiciona de todos os tipos

		System.out.print("How many values? ");
		int n = sc.nextInt();
		
		//ps.addValue("Maria"); //se adicionar uma string vai dar problemas apesar de ser Object

		for (int i = 0; i < n; i++) {
			int value = sc.nextInt();
			ps.addValue(value);
		}
		ps.print();
		
		
		Integer x = (Integer) ps.first(); //se criar uma variavel integer para guardar o valor object é preciso fazer o cast - mas o primeiro elemento é String
		System.out.println("First: " + x);

		sc.close();
		
	}

}
