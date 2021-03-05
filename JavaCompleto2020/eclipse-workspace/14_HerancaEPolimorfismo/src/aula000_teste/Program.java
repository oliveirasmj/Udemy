package aula000_teste;

public class Program {

	public static void main(String[] args) {
		
		Veiculo v = new Veiculo();
		Carro c = new Carro();
		Veiculo xpto = new Carro(); //Outra forma: Veiculo xpto = c;
		
		v.getNumRodas(); // o que v consegue ver
		c.getNumRodas(); c.getNumCavalos(); // o que c consegue ver
		xpto.getNumRodas(); // o que xpto consegue ver
		
		// UPCASTING - converter veiculo em carro
		Veiculo v2 = c; // não dá erro porque carro é um veículo
		Veiculo v3 = new Carro(); //outra forma - não dá erro porque carro é um veículo
		
		// DOWNCASTING  - converter carro em veiculo
		//Carro c2 = v; //Não se pode converter de Veiculo para carro
		Carro c2 = (Carro) v3; //Fazendo a conversao manual já é possível converter para Carro
		
		//Verificar se um objeto é um Carro
		if(v3 instanceof Carro) {
			System.out.println("É um carro");
		}
	}
}
