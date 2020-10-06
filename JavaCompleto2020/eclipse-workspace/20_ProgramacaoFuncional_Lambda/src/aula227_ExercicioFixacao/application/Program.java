package aula227_ExercicioFixacao.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import aula227_ExercicioFixacao.entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String path = "C:\\Users\\luisp\\Downloads\\Estudo\\Udemy\\JavaCompleto2020\\20_ProgramacaoFuncional_Lambda\\exercicio\\in2.txt"; // caminho do arquivo

		try(BufferedReader br = new BufferedReader(new FileReader(path))) { //Não é preciso mais declarações a seguir
			
			List<Employee> list = new ArrayList<>(); //criar lista de produtos
			
			String line = br.readLine(); // se arquivo estiver no final é devolvido nulo
			while (line != null) { // enquanto nao estiver no final
				String[] fields = line.split(","); //parar quando encontra virgula
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2]))); //adicionar cada linha à lista de produtos
				line = br.readLine(); // ler a linha e quebra
			}

			
			//LISTAR OS EMPREGADOS COM SALARIO SUPERIOR AO DADO
			System.out.print("Enter salary: ");
			double salary = sc.nextDouble();
			//criar um comparator para comparar duas strings por ordem alfabetica
			//criar a lista com os nomes
			List<String> names = list.stream()
					.filter(p -> p.getSalary() > salary) //filtrar todos os que estão acima do salario dado
					.map(p -> p.getEmail()) //.map para criar uma stream com apenas os nomes dos emails filtrados
					.sorted() //ordem crescente
					.collect(Collectors.toList()); //converter de novo para lista
			//Listar a coleção
			names.forEach(System.out::println);
			
			
			//SOMA DOS SALRIOS CUJOS FUNCIONARIOS COMECAM POR M
			double sum = list.stream()
					.filter(p -> p.getName().charAt(0) == 'M')
					.map(p -> p.getSalary()) //.map porque lista é de empregados e eu quero criar uma stream de salarios
					.reduce(0.0, (x, y) -> x + y); //reduce: permite fazer o somatorio
			System.out.println("Preço médio: " + String.format("%.2f", sum));
			
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}
}
