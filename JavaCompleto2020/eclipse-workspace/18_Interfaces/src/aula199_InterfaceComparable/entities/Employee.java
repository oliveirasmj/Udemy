package aula199_InterfaceComparable.entities;

public class Employee implements Comparable<Employee> {
	
	private String name;
	private Double salary;
	
	public Employee(String name, Double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee o) { //compara um objeto com outro - devolve negativo, 0 ou positivo se for alfabeticamente menor, iigual ou maior
		return name.compareTo(o.getName()); //ordenar por nome
		//return salary.compareTo(o.getSalary()); //ordenar por salario
		//return -salary.compareTo(o.getSalary()); //ordenar por salario descrescente
	}
	
}
