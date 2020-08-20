package aula94_exercicio;

public class Empregado {
	private int id;
	private String name;
	private double salary;
	
	public Empregado(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return getId() + ", " + getName() + ", " + String.format("%.2f", getSalary());
	}
	
	public void Aumentar(double percentagem) {
		this.salary += this.salary*percentagem/100;
	}
}
