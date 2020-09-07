package aula138_TryCatch;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] vect = sc.nextLine().split(" "); // ler varios dados na mesma linha separados por espaço em branco
		int position = sc.nextInt();
		System.out.println(vect[position]);

		System.out.println("End of program"); // Mensagem não é apresentada caso se coloque um número inválido ou uma letra em position

		sc.close();
	}

}
