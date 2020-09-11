package aula133_ExercicioFixacao.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aula133_ExercicioFixacao.entities.Company;
import aula133_ExercicioFixacao.entities.Individual;
import aula133_ExercicioFixacao.entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers:"); 
		int numberPlayers = sc.nextInt();
		
		for(int i=1; i<=numberPlayers; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: "); sc.nextLine(); String name = sc.nextLine();
			System.out.print("Anual income: "); double income = sc.nextDouble();
			
			if(type=='i') {
				System.out.print("Health expenditures: "); double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, income, healthExpenditures)); //TaxPayer t = new Individual(name, income, healthExpenditures); list.add(t);
			} else if (type=='c') {
				System.out.print("Number employees: "); int numberEmployees = sc.nextInt();
				list.add(new Company(name, income, numberEmployees));
			}
		}
		
		double sum = 0.0;
		
		System.out.println();
		System.out.println("TAXES PAID:");
		for (TaxPayer tp : list) {
			double tax = tp.imposto();
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.imposto()));
			sum += tp.imposto();
		}

		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		sc.close();
	}

}
