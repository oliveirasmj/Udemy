package fixacao_exercicioParte2;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//CurrencyConverter converter = new CurrencyConverter(); //nao vai ser necessario pois colocamos na outra classe static
		
		System.out.println("What is the dollar price? ");
		double p = sc.nextDouble();
		System.out.println("How many dollars will be bought? ");
		double m = sc.nextDouble();
		double total = CurrencyConverter.quant(p, m); //double total = converter.quant(p, m); //caso nao usasse static
		
		System.out.println("Amount to be paid in reais = " + CurrencyConverter.totalComIOF(total));
		//System.out.println("Amount to be paid in reais = " + converter.totalComIOF(total)); //caso nao usasse static
		
		sc.close();
	}
}
