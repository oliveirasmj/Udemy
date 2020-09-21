package aula203_IntroducaoGenericsV3.services;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T> { //Tipo T
	
	private List<T> list = new ArrayList<>(); //Tipo T - pode ser de todos os tipos(String, Integer,...)

	public void addValue(T value) {
		list.add(value);
	}

	public T first() {
		if (list.isEmpty()) {
			throw new IllegalStateException("List is empty");
		}
		return list.get(0);
	}

	public void print() {
		System.out.print("[");
		if (!list.isEmpty()) { //imprimir o primeiro caso haja
			System.out.print(list.get(0));
		}
		for (int i = 1; i < list.size(); i++) { //imprimir os restantes separados por virgula
			System.out.print(", " + list.get(i));
		}
		System.out.println("]");
	}
}
