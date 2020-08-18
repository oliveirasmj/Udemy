package aula89_exercicio1;

public class Aluguer {
	
	private String nomeCliente;
	private String emailCliente;
	private int numQuarto;
	
	public Aluguer(String nomeCliente, String emailCliente, int numQuarto) {
		this.nomeCliente = nomeCliente;
		this.emailCliente = emailCliente;
		this.numQuarto = numQuarto;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

//	public void setNomeCliente(String nomeCliente) {
//		this.nomeCliente = nomeCliente;
//	}

	public String getEmailCliente() {
		return emailCliente;
	}

//	public void setEmailCliente(String emailCliente) {
//		this.emailCliente = emailCliente;
//	}

	public int getNumQuarto() {
		return numQuarto;
	}

//	public void setNumQuarto(int numQuarto) {
//		this.numQuarto = numQuarto;
//	}
	
	public String toString() {
		return getNumQuarto() + ": " + getNomeCliente() + ", " + getEmailCliente();
	}
}
