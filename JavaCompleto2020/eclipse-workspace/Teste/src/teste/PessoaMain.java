package teste;

import java.util.Scanner;

public class PessoaMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduza o numero: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		Pessoa[] pessoas = new Pessoa[n];
		
		for(int i=0; i<n; i++) {
			String name = sc.nextLine();
			int age = sc.nextInt();
			Pessoa p = new Pessoa(name, age);
			pessoas[i] = p;
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(pessoas[i].getName());
			System.out.println(pessoas[i].getAge());
		}
		
		sc.close();
	}

}
