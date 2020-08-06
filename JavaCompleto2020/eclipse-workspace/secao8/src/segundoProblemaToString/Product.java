package segundoProblemaToString;

public class Product {
	
	public String name;
	public double price;
	public int quantity;
	
	public double totalValueInStock() {
		return price * quantity;
	}
	
	public void addProducts(int quantity) {
		this.quantity += quantity; //this - chama o atributo principal da classe
	}
	
	public void removeProducts(int quantity) {
		this.quantity -= quantity;
	}
	
	/*public String toString() {
		return name;
	}*/
	
	/*public String toString() {
		return name
				+ ", $ "
				+ price
				+ ", "
				+ quantity
				+ " units, Total: $ "
				+ totalValueInStock();
	}*/
	
	public String toString() {
		return name
				+ ", $ "
				+ String.format("%.2f", price)
				+ ", "
				+ quantity
				+ " units, Total: $ "
				+ String.format("%.2f", totalValueInStock());
	}
}
