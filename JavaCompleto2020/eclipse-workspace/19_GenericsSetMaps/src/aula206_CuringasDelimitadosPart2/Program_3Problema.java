package aula206_CuringasDelimitadosPart2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program_3Problema {
	
	public static void main(String[] args) {
		
		List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
		List<Double> myDoubles = Arrays.asList(3.14, 6.28);
		List<Object> myObjs = new ArrayList<Object>();
		
		copy(myInts, myObjs);
		printList(myObjs);
		copy(myDoubles, myObjs);
		printList(myObjs);
	}
	
	//recebe uma lista de origem de qualquer tipo do subtipo de Number e recebe uma lista de destino de qualquer tipo do supertipo de Number
	public static void copy(List<? extends Number> source, List<? super Number> destiny) {
		for(Number number : source) {
			destiny.add(number);
		}
	}
	
	//imprimir qualquer lista
	public static void printList(List<?> list) {
		for(Object obj : list) {
			System.out.println(obj + " ");
		}
		System.out.println();
	}
}
