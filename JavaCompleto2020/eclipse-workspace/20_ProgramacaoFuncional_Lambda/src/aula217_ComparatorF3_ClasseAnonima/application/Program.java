package aula217_ComparatorF3_ClasseAnonima.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import aula217_ComparatorF3_ClasseAnonima.entities.Product;

public class Program {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));

		//comparar - com classe anónima, assim evitamos criar uma classe MyComparator
		Comparator<Product> comp = new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
			}
		};
		
		list.sort(comp); //Forma 3 de ordenar por ordem alfabetica

		for (Product p : list) {
			System.out.println(p);
		}
	}

}
