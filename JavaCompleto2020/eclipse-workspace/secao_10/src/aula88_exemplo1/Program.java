package aula88_exemplo1;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Product[] vect = new Product[n]; //criar vetor do tipo Produtos
		double soma=0;
		
		//ler variaveis
		for(int i=0; i<vect.length; i++) {
			sc.nextLine(); //limpar buffer por causa do nextInt
			String name = sc.nextLine();
			double price = sc.nextDouble();
			
			Product product = new Product(name, price);
			vect[i] = product;
			//vect[i] = new Product(name, price);
			
			soma += vect[i].getPrice(); //somar cada leitura
		}
		
		double media =  soma/vect.length;
		System.out.printf("Soma: %.2f --- Média: %.2f", soma , media);
		
		
//		double vetor[][] = new double[n][2]; //criacao de vetor com n elementos linhas e 2 colunas
		//ler variaveis
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<2; j++) {
//				vetor[i][j] = sc.nextDouble(); //ler cada valor
//				soma += vetor[i][j]; //somar cada leitura
//			}
//		}

		sc.close();
	}

}
