package aula217_ComparatorF2_NewClass.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aula217_ComparatorF2_NewClass.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));
		
		//Collections.sort(list); //ordenar por ordem alfabetica - compare to na classe Product
		//No entanto não é a melhor solução, pois se um dia for preciso alterar a comparação temos de abrir a classe Product
		//Então vamos criar uma classe de comparação que implementa a interface Comparator
		
		list.sort(new MyComparator()); //Forma 2 de ordenar por ordem alfabetica - assim desta forma fica mais optimizado que a primeira
		
		for(Product p : list) {
			System.out.println(p);
		}
	}

}
