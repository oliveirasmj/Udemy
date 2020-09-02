package aula126_Sobreposicao.application;

import aula126_Sobreposicao.entities.Account;
import aula126_Sobreposicao.entities.BusinessAccount;
import aula126_Sobreposicao.entities.SavingsAccounts;

public class Program {

	public static void main(String[] args) {

		Account acc1 = new Account(1001, "Alex", 1000.0);
		acc1.withdraw(200.0);
		System.out.println(acc1.getBalance());
		
		Account acc2 = new SavingsAccounts(1002, "Maria", 1000.0, 0.01); //Converte para SavingsAccount
		acc2.withdraw(200.0);
		System.out.println(acc2.getBalance());
	}
}
