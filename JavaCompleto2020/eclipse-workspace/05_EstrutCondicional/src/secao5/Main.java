package secao5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Introduza um n�mero: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		if (num<0) {
			System.out.println("Negativo");
		}
		else{
			System.out.println("N�o Negativo");
		}
		
		sc.close();
	}

}
