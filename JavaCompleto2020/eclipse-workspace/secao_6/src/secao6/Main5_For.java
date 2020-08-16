package secao6;

import java.util.Scanner;

public class Main5_For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int fatorial=1;
		
		/*for(int i=1; i<=num; i++) {
			fatorial = fatorial*i;
		}*/
		
		for(int i=num; i>0; i--) {
			fatorial = fatorial*i;
		}
		
		System.out.println(fatorial);
		
		sc.close();
	}
}
