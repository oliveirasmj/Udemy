package aula144_TerceiraSolucao_Boa.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import aula144_TerceiraSolucao_Boa.entities.Reservation;
import aula144_TerceiraSolucao_Boa.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			//Criar reserva
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
	
			// Update da reserva
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			//chamar metodo update e imprimir
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e) { //Excepção que já existe
			System.out.println("Invalid date format");
		}
		catch (DomainException e) { //Excepcao que nós criamos
			System.out.println("Erro in reservation: " + e.getMessage());
		}
		catch (Exception e) { //Para qualquer tipo de excepção
			System.out.println("Unexpected error");
		}

		sc.close();
	}

}
