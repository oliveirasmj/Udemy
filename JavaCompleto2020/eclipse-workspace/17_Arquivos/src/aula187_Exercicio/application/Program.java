package aula187_Exercicio.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aula187_Exercicio.entities.Product;
//C:\Users\luisp\Downloads\Estudo\Udemy\JavaCompleto2020\17_Arquivos\exercicio\file.txt
public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List <Product> products = new ArrayList<>();

		//Caminho do ficheiro
		System.out.println("Enter a path: ");
		String strPath = sc.nextLine();
		File path = new File(strPath);

		//Tratamento do ficheiro
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine(); // se arquivo estiver no final é devolvido nulo
			
			while (line != null) { // enquanto nao estiver no final
				String[] valores = line.split(","); //sempre que encontra a virgula
				String name = valores[0];
				double preco = Double.parseDouble(valores[1]);
				int quant = Integer.parseInt(valores[2]);

				Product p = new Product(name, preco, quant);
				products.add(p);
				
				line = br.readLine(); // ler linha e quebra da linha
			}
			
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		
		//Criar um ficheiro final
//		System.out.println("getName: " + path.getName());
//		System.out.println("getParent: " + path.getParent());
//		System.out.println("getPath: " + path.getPath());
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path.getParent() + "\\fileout.txt"))) { //criar ficheiro na origem
			for(Product p : products) { 		//para cada linha do array
				bw.write(p.getName() + "," + String.format("%.2f", p.total()));
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}
		

	}

}
