package teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PessoaMain2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduza o numero: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			String name = sc.nextLine();
			int age = sc.nextInt();
			Pessoa p = new Pessoa(name, age);
			pessoas.add(p);
		}
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
		
		sc.close();
	}

}
