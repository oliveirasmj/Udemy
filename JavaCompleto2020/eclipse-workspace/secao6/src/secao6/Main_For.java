package secao6;

import java.util.Scanner;

public class Main_For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=1; i<=num; i++) {
			//se não tiver resto 0
			if (i%2 != 0) {
				System.out.println("num" + i);
			}
		}
		
		sc.close();
	}

}
