package aula98_exercicio;

import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		int c = sc.nextInt();
		
		int mat[][] = new int[l][c]; //criacao de vetor com n elementos
		
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat[i].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		int num = sc.nextInt();
		
		for(int i=0; i<l; i++) {
			for(int j=0; j<c; j++) {
				if (mat[i][j] == num) {
					System.out.println("Position " + i + "," + j + ":");
					//ver se existe numero acima
					if (i > 0) {
						System.out.println("Up: " + mat[i-1][j]);
					}
					//ver se existe numero abaixo
					if (i < mat.length-1) {
						System.out.println("Down: " + mat[i+1][j]);
					}
					//ver se existe numero a esquerda
					if (j > 0) {
						System.out.println("Left: " + mat[i][j-1]);
					}
					//ver se existe numero a direita
					if (j < mat[i].length-1) {
						System.out.println("Right: " + mat[i][j+1]);
					}
				}
			}
		}
		
		sc.close();
	}
}
