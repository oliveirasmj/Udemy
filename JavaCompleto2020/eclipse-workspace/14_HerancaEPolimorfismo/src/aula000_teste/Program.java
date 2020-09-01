package aula000_teste;

public class Program {

	public static void main(String[] args) {
		
		Veiculo v = new Veiculo();
		Carro c = new Carro();
		Veiculo xpto = new Carro();
		
		v.getNumRodas(); // o que v consegue ver
		c.getNumRodas(); c.getNumCavalos(); // o que c consegue ver
		xpto.getNumRodas(); // o que xpto consegue ver
	}

}
