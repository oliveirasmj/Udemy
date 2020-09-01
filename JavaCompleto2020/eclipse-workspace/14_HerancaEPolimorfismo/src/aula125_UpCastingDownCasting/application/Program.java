package aula125_UpCastingDownCasting.application;

import aula125_UpCastingDownCasting.entities.Account;
import aula125_UpCastingDownCasting.entities.BusinessAccount;
import aula125_UpCastingDownCasting.entities.SavingsAccounts;

public class Program {

	public static void main(String[] args) {

		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

		// UPCASTING
		Account acc1 = bacc; // não dá erro porque uma BusinessAcount é uma Account
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccounts(1004, "Anna", 0.0, 0.01);

		// DOWNCASTING
		// BusinessAccount acc4 = acc2; //Não se pode converter de Account para BusinessAcount de forma automatica
		BusinessAccount acc4 = (BusinessAccount) acc2; // Fazendo a conversao manual já é possível converter para BusinessAcount
		
		acc4.loan(100.0); // Assim já e possível reconhecer o loan
		// BusinessAccount acc5 = (BusinessAccount)acc3; //acc3 é BusinessAccount
		// portanto dá erro
		
		
		//Se acc3 for uma BusinessAccount
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount) acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}
		//Se acc3 for uma SavingsAccounts
		if (acc3 instanceof SavingsAccounts) {
			SavingsAccounts acc5 = (SavingsAccounts) acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}

//		Carro extends Veiculo
//		Carro v = new Carro;
//		Veiculo = new Carro;
//		qual a diferença???
		
	}
}
