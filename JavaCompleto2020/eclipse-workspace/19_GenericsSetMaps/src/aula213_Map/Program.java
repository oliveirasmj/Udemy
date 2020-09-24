package aula213_Map;

import java.util.Map;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {

		Map<String, String> cookies = new TreeMap<>(); //Tipo Chave e Tipo Valor | TreeMap: ordem alfabetica
		
		cookies.put("username", "Maria");
		cookies.put("email", "maria@gmail.com");
		cookies.put("phone", "918463726");
		
		cookies.remove("email");
		cookies.put("phone", "911111111"); //Vai apenas atualizar - pois nao admite repetições
		
		//Listar todos os cookies
		System.out.println("----ALL COOKIES----");
		for(String key : cookies.keySet()) {
			System.out.println(key + ": " + cookies.get(key));
		}
		
		//Ver se existe alguma chave com um determinado valor
		System.out.println();
		System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));
		
		//Ver o valor de uma chave
		System.out.println();
		System.out.println("Phone number: " + cookies.get("phone"));
		System.out.println("Email: " + cookies.get("email"));
		
		//Ver tamanho
		System.out.println();
		System.out.println("Size: " + cookies.size());
	}

}
