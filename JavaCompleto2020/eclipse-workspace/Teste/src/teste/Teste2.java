package teste;

import java.util.ArrayList;
import java.util.Scanner;

public class Teste2 {
	
	private static int soma=0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Introduza o numero de posicoes: ");
		int n = sc.nextInt();

		
		Integer[] vect = new Integer[n];
		
		for(int i=0; i<n; i++) {
			vect[i] = sc.nextInt();
			soma += vect[i];
		}
		
		System.out.println("Soma: " + soma);
	}

}
