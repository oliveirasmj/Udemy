package aula208_Set;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Program2 {

	public static void main(String[] args) {

		Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
		Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));
		
		// union
		Set<Integer> c = new TreeSet<>(a); //criar um conjunto c copiando o conjunto a (construtor)
		c.addAll(b); //fazer a uniao: colocar todos os dos dois conjuntos sem repetir
		System.out.println(c);
		
		// intersection
		Set<Integer> d = new TreeSet<>(a);
		d.retainAll(b); //fazer a intersecao - apenas os que são em comum
		System.out.println(d);
		
		// difference
		Set<Integer> e = new TreeSet<>(a);
		e.removeAll(b); //fazer a diferença - os que não existem em comum
		System.out.println(e);

	}

}
