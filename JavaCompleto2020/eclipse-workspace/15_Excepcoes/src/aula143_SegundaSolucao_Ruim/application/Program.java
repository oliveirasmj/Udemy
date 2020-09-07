package aula143_SegundaSolucao_Ruim.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import aula143_SegundaSolucao_Ruim.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException { //throws ParseException - metodo main pode lan�ar excep��o, caso nao fa�a try catch
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) { //se checkout nao for depois de checkin
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {//se estiver tudo ok fazer a reserva
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			//Update da reserva
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			//Validacao de erros de forma ruim
			String error = reservation.updateDates(checkIn, checkOut); //colocar o retorno do metodo dentro da variavel error
			if(error != null) {
				System.out.println("Error in reservation: " + error);	
			}
			else {
				System.out.println("Reservation: " + reservation);	
			}
		}
		
		sc.close();
	}

}
