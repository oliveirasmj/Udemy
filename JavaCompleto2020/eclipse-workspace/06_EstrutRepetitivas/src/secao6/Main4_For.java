package secao6;

import java.util.Scanner;

public class Main4_For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=0; i<num; i++) {
			int x1 = sc.nextInt();
			int x2 = sc.nextInt();
			
			if(x2==0) {
				System.out.println("divisao impossivel");
			}
			else {
				double divisao = (double) x1/x2;
				System.out.println(divisao);
			}
		}
		
		sc.close();
	}
}
