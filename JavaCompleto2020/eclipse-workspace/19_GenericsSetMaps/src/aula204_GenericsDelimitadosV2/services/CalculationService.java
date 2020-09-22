package aula204_GenericsDelimitadosV2.services;

import java.util.List;

public class CalculationService {
	
	//public static <T> T max(List<T> list) //falta extender o Comparable
	public static <T extends Comparable<T>> T max(List<T> list) { //ver qual é o máximo valor
		if (list.isEmpty()) { //se estiver vazia
			throw new IllegalStateException("List can't be empty");
		} 
		T max = list.get(0); //maximo = 0
		for (T item : list) { //percorrer lista e ver o max
			if (item.compareTo(max) > 0) {
				max = item;
			}
		}
		return max; //retorna max
	}
}
