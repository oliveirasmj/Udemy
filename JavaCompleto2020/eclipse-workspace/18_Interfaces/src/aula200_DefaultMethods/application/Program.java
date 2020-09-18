package aula200_DefaultMethods.application;

import java.util.Scanner;

import aula200_DefaultMethods.services.BrazilInterestService;
import aula200_DefaultMethods.services.InterestService;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Amount: ");
		double amount = sc.nextDouble();
		System.out.print("Months: ");
		int months = sc.nextInt();

		InterestService is = new BrazilInterestService(2.0);
		double payment = is.payment(amount, months);

		System.out.println("Payment after " + months + " months:");
		System.out.println(String.format("%.2f", payment));

		sc.close();
	}
}
