package aula204_GenericsDelimitadosV2.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import aula204_GenericsDelimitadosV2.entities.Product;
import aula204_GenericsDelimitadosV2.services.CalculationService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>(); //criar uma lista de produtos

		String path = "C:\\Git\\Java_Course\\JavaCompleto2020\\19_GenericsSetMaps\\exercicio\\file2.txt"; //ficheiro de texto

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) { //percorrer o ficheiro até ao fim
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1]))); //adicionar cada linha à lista de produtos
				line = br.readLine();
			}
			
			Product x = CalculationService.max(list); // x = maior da lista
			System.out.println("Most expensive:");
			System.out.println(x);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
	}
}
