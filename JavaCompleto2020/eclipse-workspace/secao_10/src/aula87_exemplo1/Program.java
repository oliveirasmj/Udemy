package aula87_exemplo1;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		double vetor[] = new double[n]; //criacao de vetor com n elementos
		
		double soma=0;
		
		//vetor[0] = sc.nextDouble();
		//vetor[1] = sc.nextDouble();
		//vetor[2] = sc.nextDouble();
		
		//ler variaveis
		for(int i=0; i<n; i++) {
			vetor[i] = sc.nextDouble(); //ler cada valor
			soma += vetor[i]; //somar cada leitura
		}
		
		double media =  soma/n;
		System.out.printf("Soma: %.2f --- Média: %.2f", soma , media);
		
		sc.close();
	}

}
