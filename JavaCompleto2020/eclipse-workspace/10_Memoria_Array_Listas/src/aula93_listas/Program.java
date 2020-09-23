package aula93_listas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(); //List é uma interface portanto preciso de uma classe que implemente uma interface(ArrayList)
		//private List<String> list = new List<>(); -- ERRADO nao se pode instanciar uma interface
		
		list.add("Maria");
		list.add("Alex");
		list.add("Bob");
		list.add("Anna");
		list.add("Pedro");
		list.add(2, "Marco"); //adicionar na posicao desejada
		list.remove("Anna"); //remover quem se chama Anna
		list.remove(1); //remover posicao numero 1
		
		System.out.println(list.size()); //ver tamanho da lista
		for(String x : list) {
			System.out.println(x);
		}
		
		System.out.println("--------------------------");
		list.removeIf(x -> x.charAt(0) == 'M'); //remover todas as strings com a primeira letra M - predicado
		for(String x : list) {
			System.out.println(x);
		}
		
		System.out.println("Index of Bob: " + list.indexOf("Bob")); //diz a posicao do elemento chamado Bob
		System.out.println("Index of Marco: " + list.indexOf("Marco")); //quando não existe retorna -1
		System.out.println("--------------------------");
		
		//colocar numa nova lista apenas com os que começam com uma determinada letra
		List<String> resut = list.stream().filter(x -> x.charAt(0) == 'B').collect(Collectors.toList());
		//1 - criar a lista result --> List<String> resut
		//2 - converter a lista para stream(tipo especial a partir do java 8 para aceitar expressoes lambda) --> list.stream()
		//3 - operacao lamda(predicado) --> filter(x -> x.charAt(0) == 'M')
		//4 - voltar a converter em lista --> collect(Collectors.toList());
		for(String x : resut) {
			System.out.println(x);
		}
		System.out.println("--------------------------");
		
		//Apanhar o primeiro elemento da lista que está de acordo com o predicado
		//se nao existir retorna nullo
		String name = list.stream().filter(x -> x.charAt(0) == 'B').findFirst().orElse(null);
		System.out.println(name);
	}

}
