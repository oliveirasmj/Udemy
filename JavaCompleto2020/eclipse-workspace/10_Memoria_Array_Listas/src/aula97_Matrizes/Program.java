package aula97_Matrizes;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int somaNegativos=0;
		
		int n = sc.nextInt(); sc.nextLine();
		int mat[][] = new int[n][n]; //criacao de vetor com n elementos
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Main diagonal:");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(j==i) {
					System.out.print(mat[i][j] + " ");
				}
				if(mat[i][j]<0) {
					somaNegativos++;
				}
			}
		}
		
//		//Outra forma de mostra a diagonal
//		for(int i=0; i<n; i++) {
//			System.out.print(mat[i][i] + " ");
//		}
		
//		//Usando o length
//		for(int i=0; i<mat.length; i++)
//		for(int j=0; j<mat[i].length; j++)
		
		System.out.println();
		System.out.println("Negative numbers = " + somaNegativos);
		
		sc.close();
	}

}
