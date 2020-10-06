package aula225_Pipeline;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) { //PIPELINE
		
		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7); //criar uma lista
		Stream<Integer> st1 = list.stream().map(x -> x * 10); //criar uma stream a partir da lista | map - aplica uma funcao a cada elemento da stream
		System.out.println(Arrays.toString(st1.toArray())); //imprimir stream - chamar o toArray(op. intermediaria - converte stream para vetor)
		
		
		int sum = list.stream().reduce(0, (x, y) -> x + y); //somar todos os elementos da stream | reduce - (pega no elmento inicial, funcao de soma)
		System.out.println("Sum: " + sum);
		
		
		List<Integer> newList = list.stream()
				.filter(x -> x % 2 == 0) //filtrar por todos os elementos pares criando uma stream -> numero 4 e numero 10
				.map(x -> x * 10) //gerar uma stream a partir da stream de pares e multiplicar para elementos por 10 -> fica 40 e 100
				.collect(Collectors.toList()); //transformar para Lista
		System.out.println(Arrays.toString(newList.toArray())); //imprimir lista
		//OU
		//System.out.println(newList);
	}

}
