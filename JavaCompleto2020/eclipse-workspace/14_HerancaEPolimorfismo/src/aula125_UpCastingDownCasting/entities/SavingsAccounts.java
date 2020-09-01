package aula125_UpCastingDownCasting.entities;

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

}
