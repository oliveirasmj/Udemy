package aula199_InterfaceComparable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aula199_InterfaceComparable.entities.Employee;

public class Program2 {

	public static void main(String[] args) {

		List<Employee> list = new ArrayList<>();
		String path = "C:\\Users\\luisp\\Downloads\\Estudo\\Udemy\\JavaCompleto2020\\18_Interfaces\\exercicio\\file2.txt"; //LISTA DE NOMES + SALÁRIO
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String employeeCsv = br.readLine();
			while (employeeCsv != null) { //enquanto nao estiver no fim
				String[] fields = employeeCsv.split(",");
				list.add(new Employee(fields[0], Double.parseDouble(fields[1]))); //adicionar à lista o texto antes da virgula e o valor após a virgula
				employeeCsv = br.readLine(); //enter
			}
			Collections.sort(list); //FORMA DE ORDENAR UMA COLEÇÃO ------> list tem de ser do tipo COMPARABLE ------> Employee implements Comparable
			for (Employee emp : list) { //percorrer a lista
				System.out.println(emp.getName() + ", " + emp.getSalary()); //imprimir
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
