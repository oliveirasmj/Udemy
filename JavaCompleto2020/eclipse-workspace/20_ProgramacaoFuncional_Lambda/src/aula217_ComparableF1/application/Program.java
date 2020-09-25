package aula217_ComparableF1.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aula217_ComparableF1.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));
		
		Collections.sort(list); //Forma 1 de ordenar por ordem alfabetica - compare to na classe Product
		
		for(Product p : list) {
			System.out.println(p);
		}
	}

}
