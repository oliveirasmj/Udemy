package aula195_ExercicioFixacao.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import aula195_ExercicioFixacao.model.entities.Contract;
import aula195_ExercicioFixacao.model.entities.Installment;
import aula195_ExercicioFixacao.model.services.ContractService;
import aula195_ExercicioFixacao.model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Enter number of installments: ");
		int n = sc.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService()); //injecao de dependencia - conforme o contrutor dessa classe
		
		contractService.processContract(contract, n);
		
//		System.out.println("Installments:");
//		for (Installment x : contract.getInstallments()) {
//			System.out.println(x);
//		}
		contract.listar();
		
		sc.close();
	}
}