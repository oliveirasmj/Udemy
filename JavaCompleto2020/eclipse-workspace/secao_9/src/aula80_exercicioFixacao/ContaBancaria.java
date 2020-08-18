package aula80_exercicioFixacao;

public class ContaBancaria {
	
	private int numConta;
	private String nomeTitular;
	private double saldo;
	
	public ContaBancaria(int numConta, String nomeTitular) {
		this.numConta = numConta;
		this.nomeTitular = nomeTitular;
	}

	//	public ContaBancaria(int numConta, String nomeTitular, double saldo) {
	//		this.numConta = numConta;
	//		this.nomeTitular = nomeTitular;
	//		this.saldo = saldo;
	//	}
	
	//esta alternativa é mais correta do ponto de vista de negocio
	public ContaBancaria(int numConta, String nomeTitular, double depositoInicial) {
		this.numConta = numConta;
		this.nomeTitular = nomeTitular;
		deposito(depositoInicial); //assim chama-se diretamente o método e caso mais tarde haja alguma taxa não se muda o código nos dois locais
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public int getNumConta() {
		return numConta;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void deposito(double valor) {
		this.saldo += valor;
	}
	
	public void saque(double valor) {
		this.saldo -= valor;
		this.saldo -= 5;
	}
	
	public String toString() {
		return "Account " + getNumConta() + ", Holder: " + getNomeTitular() + ", Balance: $ " + String.format("%.2f", getSaldo());
	}
}
