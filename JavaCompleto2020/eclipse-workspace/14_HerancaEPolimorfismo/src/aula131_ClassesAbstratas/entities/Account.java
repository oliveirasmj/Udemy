package aula131_ClassesAbstratas.entities;

public abstract class Account {
	
	private Integer number;
	private String holder;
	protected Double balance; //protected para conseguir que classes filho possam aceder a ele
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void withdraw(double amount) {//levantamento de dinheiro com taxa de 5
		balance -= amount + 5.0;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
}
