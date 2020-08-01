package secao6;

import java.util.Locale;
import java.util.Scanner;

public class Debug2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int val = sc.nextInt();
		int soma = 0;
		
		while (val!=0) {
			val = sc.nextInt();
			soma += val;
		}
		
		System.out.println("Soma: " + soma);
		sc.close();
	}

}
