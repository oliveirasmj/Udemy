package aula190_ProblemaSemInterfaces.model.services;

import aula190_ProblemaSemInterfaces.model.entities.CarRental;
import aula190_ProblemaSemInterfaces.model.entities.Invoice;

public class RentalService {
	
	private Double pricePerDay;
	private Double pricePerHour;
	
	private BrazilTaxService taxService; //tem uma associacao - não é o mais correto para este exemplo
	
	public RentalService() {
		
	}

	public RentalService(Double pricePerDay, Double pricePerHour, BrazilTaxService taxService) {
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) { //gerar a nota de pagamento do CarRental
		long t1 = carRental.getStart().getTime(); //valor em milisegundos da hora inicial
		long t2 = carRental.getFinish().getTime(); //valor em milisegundos da hora final
		
		double hours = (double)(t2-t1) / 1000 / 60 / 60; //diferenca de horas -> converter de milisegundos para segundos, para minutos e para horas
		
		double basicPayment;
		if(hours <=12.0) { //valor por Hora
			basicPayment = Math.ceil(hours) * pricePerHour; //Math.ceil(hours) - arredondar valor para cima
		}
		else { //valor por Dia
			basicPayment = Math.ceil(hours) * pricePerDay;
		}
		
		double tax = taxService.tax(basicPayment); //calcular valor do imposto
		carRental.setInvoice(new Invoice(basicPayment, tax)); //criar fatura com valor basico + taxa
	}
}
