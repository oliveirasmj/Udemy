package diversos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Primo {

	public static void main(String[] args) {
		int soma = 0;

		for (int i = 1; i <= 20; i++) {
			if(i == 1) {
				System.out.println(i + " não é primo");
			}
			if (i % 1 == 0 && i % i == 0) { //se tiver os dois divisiveis
				soma = 0;
				for (int j = 1; j <= 20; j++) {
					if (i % j == 0) { //verificar se tem mais do que 2 divisiveis
						soma++;
					}
				}
				if (soma > 2) {
					System.out.println(i + " não é primo");
				}
				else {
					System.out.println(i + " é primo");
				}
			}
		}
	}

}
