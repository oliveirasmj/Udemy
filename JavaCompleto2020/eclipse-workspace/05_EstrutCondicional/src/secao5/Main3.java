package secao5;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int num2 = sc.nextInt();
		
		//System.out.println("Num 1: " + num + "\nNum2: " + num2);
		
		if (num%num2==0 || num2%num==0) {
			System.out.println("Sao Multiplos");
		}
		else {
			System.out.println("N�o sao multiplos");
		}
		
		sc.close();
	}

}
