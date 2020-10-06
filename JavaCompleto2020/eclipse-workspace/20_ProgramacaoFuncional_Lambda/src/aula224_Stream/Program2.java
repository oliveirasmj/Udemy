package aula224_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program2 {

	public static void main(String[] args) { //STREAM V2
		
		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7); //criar uma lista
		Stream<Integer> st1 = list.stream().map(x -> x * 10); //criar uma stream a partir da lista | map - aplica uma funcao a cada elemento da stream
		System.out.println(Arrays.toString(st1.toArray())); //imprimir stream - chamar o toArray(op. intermediaria - converte stream para vetor)
		
		Stream<String> st2 = Stream.of("Maria", "Alex", "Bob"); //criar stream já com valores
		System.out.println(Arrays.toString(st2.toArray())); //imprimir stream - chamar o toArray(op. intermediaria - converte stream para vetor)
		
		Stream<Integer> st3 = Stream.iterate(0, x -> x + 2); //criar stream recebendo o iterate - o primeiro elemento vai ser 0 e os proximos elementos soa gerados com x+2 - stream potencialmente infinita
		System.out.println(Arrays.toString(st3.limit(10).toArray())); //colocar um limite para nao ser infinito - operação intermediaria - vai gerar nova stream
		
		//Fibonacci - soma de dois em dois - primeiros elementos: [0, 1]
		Stream<Long> st4 = Stream.iterate(new long[]{ 0L, 1L }, p->new long[]{ p[1], p[0]+p[1] }).map(p -> p[0]);
		System.out.println(Arrays.toString(st4.limit(0).toArray())); //colocar um limite para nao ser infinito
		
	}

}
