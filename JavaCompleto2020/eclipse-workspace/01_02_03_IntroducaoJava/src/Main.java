import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		double x = 10.2626452;
		int y = 3;
		String var = "ola";
		char letra = 'A';

		System.out.println("Ol� Mundo");
		System.out.println(x);
		System.out.printf("%.4f%n", x);
		System.out.printf("%.2f", x);
		System.out.printf("Double: %f - Inteiro: %d - String: %s - Letra: %c", x, y, var, letra);
		
		Locale.setDefault(Locale.US);
		System.out.println(); System.out.println();
		System.out.println(x);
		
		//Ler variaveis at� ao espa�o
		System.out.print("Escreva: ");
		Scanner sc = new Scanner(System.in);
		//String variavel = sc.next();
		int variavelint = sc.nextInt(); //Cuidado que pode ser preciso limpar o buffer a seguir para mudar de linha
		
		//double variaveldouble = sc.nextDouble();
		//char variavelchar = sc.next().charAt(0); // 0 � o primeiro caracter que encontrar
		System.out.println("A vari�vel �: " + variavelint);
		
		//Ler variaveis ate apertar o enter
		sc.nextLine(); //limpar buffer - fica pendente na linha anterior por causa do sc.nextInt()  --> � preciso para que proxima var nao fique branca
		System.out.print("Escreva: ");
		String linha = sc.nextLine();
		System.out.println("A linha �: " + linha);
		
		//Truncado e valor real
		int a=5, b=2;
		System.out.println(a/b); System.out.println((double)a/b);
		
		//https://pt.stackoverflow.com/questions/186906/linha-de-c%C3%B3digo-ignorada
	}

}
