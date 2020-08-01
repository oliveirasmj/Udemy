package secao6;

import java.util.Scanner;

public class Main2_For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int in=0, out=0;
		
		for(int i=0; i<num; i++) {
			int x = sc.nextInt();
			
			if (x>=10 && x<=20) {
				//System.out.println(i + "in");
				in++;
			}
			else {
				//System.out.println(i + "out");
				out++;
			}
		}
		System.out.println(in + " in");
		System.out.println(out + " out");
		
		sc.close();
	}
}
