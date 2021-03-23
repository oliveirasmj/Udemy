package application;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		// SPAIN
    	System.out.println(findWord(Arrays.asList("I>N","A>I","P>A","S>P"))); //SPAIN
//    	System.out.println(findWord(Arrays.asList("P>E","E>R","R>U"))); //PERU
//      System.out.println(findWord(Arrays.asList("U>N", "G>A", "R>Y", "H>U", "N>G", "A>R"))); // HUNGARY
//      System.out.println(findWord(Arrays.asList("I>F", "W>I", "S>W", "F>T"))); // SWIFT
//      System.out.println(findWord(Arrays.asList("R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"))); // PORTUGAL
//      System.out.println(findWord(Arrays.asList("W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T"))); // SWITZERLAND
		
    	//Map(K, N)
    	//I -> N
    	//A -> I
    	//P -> A
    	//S -> P
	}
	
	public static String findWord(List<String> relations) {
		
		String palavra = "";
		for(int i=0; i<relations.size(); i++) {
			String s1 = relations.get(i);
			char l1 = s1.charAt(0); // I
			//char l2 = s1.charAt(1);
			char l3 = s1.charAt(2); // N
			palavra += l1;
		}
		
		for(int j=0; j<palavra.length(); j++) {
			
		}
		
		return palavra;
	}

}
