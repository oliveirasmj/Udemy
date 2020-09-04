package aula131_ClassesAbstratas.application;

import java.util.ArrayList;
import java.util.List;

import aula131_ClassesAbstratas.entities.Account;
import aula131_ClassesAbstratas.entities.BusinessAccount;
import aula131_ClassesAbstratas.entities.SavingsAccounts;

public class Program {

	public static void main(String[] args) {
		
		//Account acc1 = new Account(1001, "Alex", 1000.0); //Não dá para instanciar porque é abstract
		Account acc2 = new SavingsAccounts(1002, "Maria", 1000.0, 0.01);
		Account acc3 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
		Account acc4 = new BusinessAccount(1004, "Alex", 500.0, 0.01);
		Account acc5 = new BusinessAccount(1005, "Anna", 500.0, 500.0);
		
		List<Account> list = new ArrayList<>(); 
		list.add(acc2); list.add(acc3); list.add(acc4); list.add(acc5);
		// É possível adicionar objetos de tipos diferentes na lista porque têm em comum a variável do mesmo tipo(Account)
		
		double sum = 0.0;
		for (Account acc : list) {
			sum += acc.getBalance();
		}
		System.out.println("Total balance: " + sum);
	}
}
