package exercicioFixacao;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ContaBancaria bancaria;
		
		System.out.print("Introduza o número da conta: ");
		int num = sc.nextInt();
		System.out.print("Introduza o nome da conta: ");
		sc.nextLine(); //limpar buffer - fica pendente na linha anterior por causa do sc.nextInt()
		String nome = sc.nextLine();
		
		System.out.print("Quer fazer um depósito (y/n)? ");
		char opcao = sc.next().charAt(0);
		
		double deposito=0;
		if (opcao == 'y') {
			System.out.print("Introduza o deposito inicial: ");
			deposito = sc.nextDouble();
			bancaria = new ContaBancaria(num, nome, deposito);
			System.out.println();
			System.out.println("Account data: ");
			System.out.println(bancaria);
			System.out.println();
		}
		else {
			bancaria = new ContaBancaria(num, nome);
			System.out.println();
			System.out.println("Account data: ");
			System.out.println(bancaria);
			System.out.println();
		}
		
		System.out.print("Enter a deposit value: ");
		num = sc.nextInt();
		System.out.println("Updated account data:");
		bancaria.deposito(num);
		System.out.println(bancaria);
		
		System.out.println();
		System.out.print("Enter a withdraw value: ");
		num = sc.nextInt();
		System.out.println("Updated account data:");
		bancaria.saque(num);
		System.out.println(bancaria);
		
		sc.close();
	}

}
