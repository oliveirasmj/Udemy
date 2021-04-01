package blip;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EntrevistaFinal {

	public static void main(String[] args) {

		System.out.println(findWord(Arrays.asList("I>N", "A>I", "P>A", "S>P"))); // SPAIN
		System.out.println(findWord(Arrays.asList("P>E", "E>R", "R>U"))); // PERU
		System.out.println(findWord(Arrays.asList("U>N", "G>A", "R>Y", "H>U", "N>G", "A>R"))); // HUNGARY
		System.out.println(findWord(Arrays.asList("I>F", "W>I", "S>W", "F>T"))); // SWIFT
		System.out.println(findWord(Arrays.asList("R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"))); // PORTUGAL
		System.out.println(findWord(Arrays.asList("W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T"))); // SWITZERLAND

		// Map(K, N)
		// I -> N (N vem a seguir ao I)
		// A -> I
		// P -> A
		// S -> P
	}

	public static String findWord(List<String> relations) {

		Map<String, String> word = new LinkedHashMap<>();

		// Escrever
		for (int i = 0; i < relations.size(); i++) {
			// relations.get(0); //imprime I>N
			// relations.get(0).substring(0, 1); //imprime I>N
			word.put(relations.get(i).substring(0, 1), relations.get(i).substring(2, 3)); // (I,N)
		}

		String finalWord = "";
		for (Map.Entry<String, String> entry : word.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			// System.out.println(String.format("key: %s | value: %s", key, value));

			if (finalWord.length() == 0) { // se ainda for vazio coloca K e N (as duas logo em primeiro - I e N)
				finalWord += key + value;
			} else { // se não estiver vazio

				if (finalWord.contains(value)) { // se letra ja existir na palavra
					// procurar a letra value
					int posLetra = finalWord.indexOf(value); // R
					// colocar a key antes de value
					StringBuilder stringBuilder = new StringBuilder(finalWord);
					stringBuilder.insert(posLetra, key);
					finalWord = stringBuilder.toString();
					
				} else {
					int posLetra = finalWord.indexOf(key); // E
					// colocar a key antes de value
					StringBuilder stringBuilder = new StringBuilder(finalWord);
					stringBuilder.insert(posLetra + 1, value);
					finalWord = stringBuilder.toString();
				}
			}
		}

		return "" + finalWord;
	}

}