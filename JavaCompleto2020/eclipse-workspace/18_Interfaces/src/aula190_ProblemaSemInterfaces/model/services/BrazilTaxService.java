package aula190_ProblemaSemInterfaces.model.services;

public class BrazilTaxService {
	
	//double em minusculo porque assumimos que será sempre um valor nunca nulo
	public double tax(double amount) { //calcular imposto do Brazil a partir de uma certa quantia de dinheiro(amount)
		if (amount <= 100.0) {
			return amount * 0.2;
		}
		else {
			return amount * 0.15;
		}
	}
}
