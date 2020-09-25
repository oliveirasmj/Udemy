package aula217_ComparatorF5_Optimizado.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import aula217_ComparatorF5_Optimizado.entities.Product;

public class Program {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));

		//comparar - com Função Anónima (Lambda) - forma menos extensa
		list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase())); //Forma 5 de ordenar por ordem alfabetica

		for (Product p : list) {
			System.out.println(p);
		}
	}

}
