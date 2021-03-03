package teste;

public class Pessoa {
	
	private String name;
	private int age;
	
	public Pessoa() {
		
	}
	
	public Pessoa (String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void imprime() {
		System.out.println("Dados: " + this.name + " - " + this.age);
	}
}
