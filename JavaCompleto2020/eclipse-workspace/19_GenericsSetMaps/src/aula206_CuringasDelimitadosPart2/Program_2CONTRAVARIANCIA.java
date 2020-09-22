package aula206_CuringasDelimitadosPart2;

import java.util.ArrayList;
import java.util.List;

public class Program_2CONTRAVARIANCIA { 

	public static void main(String[] args) {
		
		List<Object> myObjs = new ArrayList<Object>();
		myObjs.add("Maria");
		myObjs.add("Alex");
		
		List<? super Number> myNums = myObjs; //Criar myNums (de qualquer tipo que seja SUPERTIPO de Number) e copiar para myObjs
		//Supertipo de Number é Object
		
		myNums.add(10); //já é possível adicionar
		myNums.add(3.14); //já é possível adicionar
		
		//Number x = myNums.get(0); // erro de compilacao - Number é SUBTIPO de object
		
		
		//CONTRAVARIANCIA: get - ERROR; put - OK
	}
}
