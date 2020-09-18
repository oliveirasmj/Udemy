package aula199_InterfaceComparable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		String path = "C:\\Users\\luisp\\Downloads\\Estudo\\Udemy\\JavaCompleto2020\\18_Interfaces\\exercicio\\file.txt"; //LISTA DE NOMES
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String name = br.readLine();
			while (name != null) { //enquanto nao estiver no fim
				list.add(name); //adicionar à lista
				name = br.readLine(); //enter
			}
			Collections.sort(list); //FORMA DE ORDENAR UMA COLEÇÃO ------> list tem de ser do tipo COMPARABLE
			for (String s : list) { //percorrer a lista
				System.out.println(s); //imprimir
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
