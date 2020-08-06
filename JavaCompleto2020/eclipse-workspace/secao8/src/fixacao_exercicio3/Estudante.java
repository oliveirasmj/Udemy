package fixacao_exercicio3;

public class Estudante {
	
	public String nome;
	public double nota1;
	public double nota2;
	public double nota3;
	
	public double somaNotas() {
		return nota1+nota2+nota3;
	}
	
	public double pontosParaPassar() {
		if (somaNotas()>60) {
			return 0;
		}
		else {
			return 60 - somaNotas();
		}
	}
}
