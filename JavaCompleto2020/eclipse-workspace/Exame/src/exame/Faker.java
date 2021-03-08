package exame;

import java.util.Random;

public class Faker {

    public String letterify(String letterString) {
        
        Random rnd = new Random();
		char c = (char) ('a' + rnd.nextInt(26)); //generate
		String charToString = String.valueOf(c); //convert to string
		String letterString2 = letterString.replaceAll("\\?", charToString); //replace ?
        
        return letterString2;
    }

    public String numerify(String numberString) {
        int number = generateRandomNumbers(0, 9); //generate number
        String numberToString = String.valueOf(number); //convert to string
        String letterString2 = numberString.replaceAll("#", numberToString); //replace #
        
        return letterString2;
    }

    public String bothify(String string) {
        String l1 = letterify(string); //first op
        String l2 = numerify(l1); //second op
        return l2;
    }
    
    public static int generateRandomNumbers(int min, int max) { 
		Random r = new Random(); 
		return r.nextInt((max - min) + 1) + min;
	} 

}
