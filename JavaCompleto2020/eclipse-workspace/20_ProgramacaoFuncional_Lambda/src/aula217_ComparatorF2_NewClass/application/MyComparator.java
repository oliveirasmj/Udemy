package aula217_ComparatorF2_NewClass.application;

import java.util.Comparator;

import aula217_ComparatorF2_NewClass.entities.Product;

public class MyComparator implements Comparator<Product>{ //Aqui, em vez do Comparable usamos o Comparator(interface funcional - apenas 1 metodo abstrato)

	@Override
	public int compare(Product p1, Product p2) {
		return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()); //compara um objeto com outro - devolve negativo, 0 ou positivo se for alfabeticamente menor, iigual ou maior
	}

}
