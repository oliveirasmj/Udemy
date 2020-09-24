package aula211_ExercicioResolvido.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import aula204_GenericsDelimitadosV2.entities.Product;
import aula211_ExercicioResolvido.entities.LogEntry;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String path = "C:\\Users\\luisp\\Downloads\\Estudo\\Udemy\\JavaCompleto2020\\19_GenericsSetMaps\\exercicio\\file3.txt";
//		System.out.println("Enter file full pah: ");
//		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Set<LogEntry> set = new HashSet<>(); //Criar HashSet - é rápido e não importa a ordem
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(" ");
				String username = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				
				set.add(new LogEntry(username, moment)); //adicionar cada linha ao Set de LogEntry
				line = br.readLine();
			}
			System.out.println("Total user: " + set.size());
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
