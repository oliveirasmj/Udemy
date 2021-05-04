package aula126_SobreposicaoPalavraSuper.entities;

public class SavingsAccounts extends Account{
	
	private Double interestRate;
	
	public SavingsAccounts() {
		super();
	}

	public SavingsAccounts(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void updateBalance() {
		balance += balance * interestRate;
	}
	
	@Override
	public void withdraw(double amount) { //SOBREPOSICAO(chamar metodo da superclasse e fazer de forma diferente) - levantamento de dinheiro sem taxa
		balance -= amount; //a conta é feita de forma diferente
	}
	
	public void teste() {
		
	}
}
