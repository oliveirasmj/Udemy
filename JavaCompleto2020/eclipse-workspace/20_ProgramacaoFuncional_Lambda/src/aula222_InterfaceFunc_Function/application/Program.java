package aula222_InterfaceFunc_Function.application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import aula222_InterfaceFunc_Function.entities.Product;


public class Program {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		// FORMAS DE A PARTIR DE UMA LISTA GERAR UMA NOVA COM OS NOMES EM MAISCULAS
		
		//FORMA 1 - expressão Lambda inline
		//Funcao map so funciona para stream, portanto temos de converter a lista para stream e depois voltar a colocar para stream
		List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
				
		//FORMA 2 - expressão Lambda declarada
		//Funcao map so funciona para stream, portanto temos de converter a lista para stream e depois voltar a colocar para stream
//		Function<Product, String> func = p -> p.getName().toUpperCase();
//		List<String> names = list.stream().map(func).collect(Collectors.toList()); //no map colocar a funcao lambda
				
		//FORMA 3 - criar uma classe(UpperCaseName) que implementa interface Function
		//	Funcao map so funciona para stream, portanto temos de converter a lista para stream e depois voltar a colocar para stream
		//  list.stream().map(new UpperCaseName()) --> aplicar a cada elemento da lista uma instancia do UpperCaseName 
		//  .collect(Collectors.toList()) --> converter a stream em lista
		//  List<String> names =  --> atribuir para uma nova lista
//		List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList()); 

				
		//FORMA 4 - criar novo método static na classe Product
//		List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList()); //com referência para o método
				
		//FORMA 5 - criar novo método comum na classe Product
//		List<String> names = list.stream().map(Product::nonstaticUpperCaseName).collect(Collectors.toList()); //com referência para o método
		
		
		//LISTAR
		names.forEach(System.out::println);
	}

}
