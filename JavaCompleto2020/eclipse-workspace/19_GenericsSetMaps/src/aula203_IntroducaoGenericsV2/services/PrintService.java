package aula203_IntroducaoGenericsV2.services;

import java.util.ArrayList;
import java.util.List;

public class PrintService {
	
	private List<Object> list = new ArrayList<>();//sendo objet ja vai resolver quase todos os problemas pois é possivel adicionar de todos os tipos

	public void addValue(Object value) {
		list.add(value);
	}

	public Object first() {
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
