package hello.world.exercicio5;

import javax.jws.WebService;

@WebService
public class Aluno {
	
	private String nome;
	private int numero;
	private String estatuto;
	
	public Aluno(String nome, int numero, String estatuto) {
		this.nome = nome;
		this.numero = numero;
		this.estatuto = estatuto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEstatuto() {
		return estatuto;
	}

	public void setEstatuto(String estatuto) {
		this.estatuto = estatuto;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", numero=" + numero + ", estatuto=" + estatuto + "]";
	}
	
}
