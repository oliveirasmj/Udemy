package aula187_Exercicio.entities;

public class Product {
	
	private String name;
	private double preco;
	private int quant;
	
	public Product(String name, double preco, int quant) {
		this.name = name;
		this.preco = preco;
		this.quant = quant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	public double total() {
		return preco*quant;
	}

	@Override
	public String toString() {
		return name + ", " + preco + ", " + quant;
	}
	
	
}
