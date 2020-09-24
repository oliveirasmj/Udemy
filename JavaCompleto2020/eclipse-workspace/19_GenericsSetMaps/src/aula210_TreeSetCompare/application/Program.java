package aula210_TreeSetCompare.application;

import java.util.Set;
import java.util.TreeSet;

import aula210_TreeSetCompare.entities.Product;

public class Program {

	public static void main(String[] args) {

		Set<Product> set = new TreeSet<>(); //mais lento e ordenado alfabeticamente pelo CompareTo
		
		set.add(new Product("Tv", 900.0));
		set.add(new Product("Notebook", 1200.0));
		set.add(new Product("Tablet", 400.0));
		
		for (Product p : set) {
			System.out.println(p);
		}

	}

}
