package aula224_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) { //STREAM
		
		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7); //criar uma lista
		Stream<Integer> st1 = list.stream(); //criar uma stream a partir da lista
		
		System.out.println(Arrays.toString(st1.toArray())); //imprimir stream - chamar o toArray(op. intermediaria - converte stream para vetor)
	}

}
