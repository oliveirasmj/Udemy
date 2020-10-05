package aula220_InterfaceFunc_Predicate.entities;

public class Product{

	private String name;
	private Double price;
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
	//FORMA 4
	public static boolean staticProductPredicate(Product p) { //static trabalha com o produto que se passa
		return p.getPrice() >= 100.0; //retorna os produtos a remover como true
	}
	
	//FORMA 5
	public boolean nonstaticProductPredicate() { //non static - trabalha com o objeto onde está
		return price >= 100.0; //retorna os produtos a remover como true
	}
	
}
