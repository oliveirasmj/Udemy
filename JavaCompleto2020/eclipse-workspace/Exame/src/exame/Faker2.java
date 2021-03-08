package exame;

import java.util.Random;

public class Faker2 {

	public String letterify(String letterString) {

		String letterString2 = "";

		for (int i = 0; i < letterString.length(); i++) {
			//Random rnd = new Random();
			//char c = (char) ('a' + rnd.nextInt(26)); // generate char -> a + 26char
			
			String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz"; //alphabet + numbers
			Random rnd = new Random();
			char c = alphabet.charAt(rnd.nextInt(alphabet.length())); //generate number or letter
			
			String charToString = String.valueOf(c); // convert to string

			String position = letterString.substring(i, i + 1); // actual letter of letterString
			letterString2 += position.replaceAll("\\?", charToString); // replace ?
		}

		return letterString2;
	}

	public String numerify(String numberString) {

		String letterString2 = "";

		for (int i = 0; i < numberString.length(); i++) {
			int number = generateRandomNumbers(0, 9); // generate number
			String numberToString = String.valueOf(number); // convert to string

			String position = numberString.substring(i, i + 1); // actual number of letterString
			letterString2 += position.replaceAll("#", numberToString); // replace #
		}
		return letterString2;
	}

	public String bothify(String string) {
		//String l1 = letterify(string); // first op.
		//String l2 = numerify(l1); // second op.	
		//return l2;
		
		return letterify(numerify(string));
	}

	public static int generateRandomNumbers(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
