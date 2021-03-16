package diversos;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrama {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();
		String r = sc.nextLine();
		
		//transformar em array
		char[] a = s.toCharArray();
		char[] b = r.toCharArray();
		
		//ordena para garantir a comparação simplificada
		Arrays.sort(a);
		Arrays.sort(b);

		if (Arrays.equals(a, b)) {
			System.out.println("Anagrama");
		} else {
			System.out.println("Não é anagrama");
		}
	}

}
