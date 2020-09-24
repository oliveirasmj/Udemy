package aula214_ExercicioFixacao.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = "C:\\Users\\luisp\\Downloads\\Estudo\\Udemy\\JavaCompleto2020\\19_GenericsSetMaps\\exercicio\\file4.txt";
//		System.out.println("Enter file full pah: ");
//		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			Map<String, Integer> votos = new HashMap<>(); //criar o hashmap
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String nome = fields[0];
				Integer numero = Integer.parseInt(fields[1]);
				
				if (votos.containsKey(nome)) { //se o map ja tiver aquele nome de eleitor
					int votesSoFar = votos.get(nome); //votosSoFar = votos dessa linha
					votos.put(nome, numero + votesSoFar); //votos = votos + votosSoFar
				}
				else { //se ainda nao tiver esse nome de eleitor
					votos.put(nome, numero); //adiciona
				}
				
				line = br.readLine();
			}
			
			//Imprimir tudo
			for(String key : votos.keySet()) {
				System.out.println(key + ": " + votos.get(key));
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}

}
