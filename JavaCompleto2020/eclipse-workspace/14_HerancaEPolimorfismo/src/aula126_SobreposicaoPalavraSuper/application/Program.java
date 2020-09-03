package aula126_SobreposicaoPalavraSuper.application;

import aula126_SobreposicaoPalavraSuper.entities.Account;
import aula126_SobreposicaoPalavraSuper.entities.BusinessAccount;
import aula126_SobreposicaoPalavraSuper.entities.SavingsAccounts;

public class Program {

	public static void main(String[] args) {

		Account acc1 = new Account(1001, "Alex", 1000.0); //possui todos os atributos de Account
		acc1.withdraw(200.0);
		System.out.println(acc1.getBalance()); //A taxa é descontada
		
		Account acc2 = new SavingsAccounts(1002, "Maria", 1000.0, 0.01); //Converte para SavingsAccount - //possui todos os atributos de Account mais os de SavingsAccount
		acc2.withdraw(200.0);
		System.out.println(acc2.getBalance()); //Não há taxa
		
		//Tanto acc1 como acc2 são variáveis do mesmo tipo (Account), mas objetos de tipos diferentes na memória
	}
}
