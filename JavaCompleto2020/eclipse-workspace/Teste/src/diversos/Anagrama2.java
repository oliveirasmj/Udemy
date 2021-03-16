package diversos;

import java.util.HashMap;
import java.util.Scanner;

public class Anagrama2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String st1 = sc.next();
		String st2 = sc.next();

		Boolean result = anagram(st1, st2);
		if (result == true)
			System.out.println("congrat! these are anagrams");
		else
			System.out.println("these are not anagrams");
	}

	static boolean anagram(String st1, String st2) {

		// Criar os dois hashmaps
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();

		// colocar num array de char
		char[] arr1 = st1.toCharArray();
		char[] arr2 = st2.toCharArray();

		if (arr1.length != arr2.length) { 	// se tiverem tamanhos diferentes
			return false; 					// nao sao anagramas
		} 
		else { 								// se tiverem tamanhos iguais
			
			for (int i = 0; i < arr1.length; i++) { 		// percorrer array de char da palavra1
				if (map1.containsKey(arr1[i])) { 			// se aquela letra existir no map
					int count1 = (int) map1.get(arr1[i]); 	// verificar o numero de vezes da letra
					map1.put(arr1[i], count1++); 			// adicionar mais uma contagem
				} else { 									// se letra já existir
					map1.put(arr1[i], 1); 					// contar como uma
				}
			}

			for (int j = 0; j < arr2.length; j++) { 		// Fazer o mesmo para a palavra2
				if (map2.containsKey(arr2[j])) {
					int count2 = (int) map2.get(arr2[j]);

					map2.put(arr2[j], count2++);
				} else {
					map2.put(arr2[j], 1);
				}
			}

			// ver se maps sao iguais
			if (map1.equals(map2))
				return true;
			else
				return false;
		}
	}
}
