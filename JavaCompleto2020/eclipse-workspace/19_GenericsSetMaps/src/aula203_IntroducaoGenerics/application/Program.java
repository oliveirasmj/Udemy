package aula203_IntroducaoGenerics.application;

import java.util.Scanner;

import aula203_IntroducaoGenerics.services.PrintService;
import aula203_IntroducaoGenerics.services.PrintServiceString;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		PrintService ps = new PrintService();
		//PrintServiceString ps = new PrintServiceString();		//assim ja funciona com strings mas é má programacao repetrir codigo

		System.out.print("How many values? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int value = sc.nextInt();
			ps.addValue(value);
		}

		ps.print();
		System.out.println("First: " + ps.first());

		sc.close();
		
	}

}
