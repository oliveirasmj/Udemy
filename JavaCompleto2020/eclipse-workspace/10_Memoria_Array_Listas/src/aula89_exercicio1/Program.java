package aula89_exercicio1;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many rooms will be rented? ");
		int n = sc.nextInt(); sc.nextLine();
		
		Aluguer vect[] = new Aluguer[10]; //criar um array do tipo Aluguer
		
		for(int i=0; i<n; i++) {
			System.out.println("Rent #" + i);
			System.out.print("Nome: "); String nome = sc.nextLine();
			System.out.print("Email: "); String email = sc.nextLine();
			System.out.print("Room: "); int num = sc.nextInt(); sc.nextLine();
			
			Aluguer aluguer = new Aluguer(nome, email, num); 	//criar um objeto novo
			vect[num] = aluguer;								//adicioná-lo ao array criado
		}
		
		System.out.println("Busy rooms");
		for(int i=0; i<vect.length; i++) {
			if (vect[i] != null) {
				System.out.println(vect[i]);
			}
		}
		
		sc.close();
	}

}
