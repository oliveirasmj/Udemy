package secao6;

import java.util.Scanner;

public class Main3_For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=0; i<num; i++) {
			double x1 = sc.nextDouble();
			double x2 = sc.nextDouble();
			double x3 = sc.nextDouble();
			
			double media = (x1 * 2.0 + x2 * 3.0 + x3 * 5.0) / 10.0;
			System.out.printf("%.1f%n", media);
		}
		
		sc.close();
	}
}
