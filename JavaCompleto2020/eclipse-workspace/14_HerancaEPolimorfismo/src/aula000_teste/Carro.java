package aula000_teste;

public class Carro extends Veiculo{
	
	private Integer numCavalos;

	public Carro() {
		super();
	}
	
	public Carro(Integer numRodas, Integer numCavalos) {
		super(numRodas);
		this.numCavalos = numCavalos;
	}

	public Integer getNumCavalos() {
		return numCavalos;
	}

	public void setNumCavalos(Integer numCavalos) {
		this.numCavalos = numCavalos;
		//System.out.println(super.getNumRodas()); //chamar um metodo da superclasse
	}	
}
