package aula133_ExercicioFixacao.entities;

public class Company extends TaxPayer{
	
	private Integer numberEmployees;
	
	public Company() {
		super();
	}

	public Company(String name, Double anualIncome, Integer numberEmployees) {
		super(name, anualIncome);
		this.numberEmployees = numberEmployees;
	}
	
	public Integer getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(Integer numberEmployees) {
		this.numberEmployees = numberEmployees;
	}

	@Override
	public Double imposto() {
		if(numberEmployees <= 10) {
			return super.getAnualIncome()*0.16;
		} else {
			return super.getAnualIncome()*0.14;
		}
	}

}
