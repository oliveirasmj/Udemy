package aula193_ProblemaComInterfaces.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import aula190_ProblemaSemInterfaces.model.entities.CarRental;
import aula190_ProblemaSemInterfaces.model.entities.Vehicle;
import aula190_ProblemaSemInterfaces.model.services.BrazilTaxService;
import aula190_ProblemaSemInterfaces.model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy HH:mm): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy HH:mm): ");
		Date finish = sdf.parse(sc.nextLine());
		//instanciar objeto CarRental
		CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
		
		System.out.print("Enter price per hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		double pricePerDay = sc.nextDouble();
		//instanciar objeto RentalService
		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService()); //BrazilTaxService - injecao de dependencia por meio de construtor - classe RentalService
		
		//gerar a nota de pagamento do CarRental
		rentalService.processInvoice(cr);
		
		//Imprimir o resumo
		System.out.println("INVOICE:");
		System.out.println("Basic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
		System.out.println("Total payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));
		
		sc.close();
	}

}
