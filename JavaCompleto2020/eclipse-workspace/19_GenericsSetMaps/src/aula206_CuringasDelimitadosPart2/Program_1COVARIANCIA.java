package aula206_CuringasDelimitadosPart2;

import java.util.ArrayList;
import java.util.List;

public class Program_1COVARIANCIA { 

	public static void main(String[] args) {
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(10);
		intList.add(5);
		
		List<? extends Number> list = intList; //Criar list (de qualquer tipo que seja SUBTIPO de Number) e copiar para inList
		//Subtipo de Number é Integer, Byte, Long, Short, Float e Double
		
		Number x = list.get(0);
		
		//list.add(20.2); //erro de compilacao - nao da para adicionar a uma lista generica pois o valor pode nao ser Integer e neste caso é double
		
		
		//COVARIANCIA: get - OK; put - ERROR
	}
}
