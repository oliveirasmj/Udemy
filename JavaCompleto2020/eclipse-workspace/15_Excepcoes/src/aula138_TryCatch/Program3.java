package aula138_TryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			String[] vect = sc.nextLine().split(" "); //ler varios dados na mesma linha separados por espaço em branco
			int position = sc.nextInt();
			System.out.println(vect[position]);
		}
		catch (ArrayIndexOutOfBoundsException e) { //Excepcao que é gerada quando o número não está dentro dos limites
			System.out.println("Invalid position");
		}
		catch (InputMismatchException e) { //Excepcao que é gerada quando é inserida uma letra
			System.out.println("Input error");
		}
		System.out.println("End of program"); //Agora mensagem já é apresentada com limite invalido ou com letra
		
		sc.close();
	}

}
