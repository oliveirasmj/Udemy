package secao5;

import java.util.Locale;
import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		int item = sc.nextInt();
		double quant = sc.nextInt();

		if (item == 1) {
			System.out.printf("Total: R$ %.2f", 4.0 * quant);
		} else if (item == 2) {
			System.out.printf("Total: R$ %.2f", 4.5 * quant);
		} else if (item == 3) {
			System.out.printf("Total: R$ %.2f", 5.0 * quant);
		} else if (item == 4) {
			System.out.printf("Total: R$ %.2f", 2.0 * quant);
		} else if (item == 5) {
			System.out.printf("Total: R$ %.2f", 1.5 * quant);
		}

		sc.close();
	}

}
