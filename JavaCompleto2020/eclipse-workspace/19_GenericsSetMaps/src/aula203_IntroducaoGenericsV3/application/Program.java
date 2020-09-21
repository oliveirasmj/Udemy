package aula203_IntroducaoGenericsV3.application;

import java.util.Scanner;

import aula203_IntroducaoGenericsV3.services.PrintService;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//agora é do tipo Integer - sendo que a classe PrintService é Generics <T> pode ser de todos os tipos
		PrintService<Integer> ps = new PrintService<>(); //posso mudar de Integer para o que for desejável

		System.out.print("How many values? ");
		int n = sc.nextInt();
		
		//ps.addValue("Maria"); //agora já não é permitido porque só pode aceitar inteiros

		for (int i = 0; i < n; i++) {
			int value = sc.nextInt();
			ps.addValue(value);
		}
		ps.print();
		
		
		Integer x = ps.first(); //já não é preciso cast porque vai ser sempre Integer
		System.out.println("First: " + x);

		sc.close();
		
	}

}
