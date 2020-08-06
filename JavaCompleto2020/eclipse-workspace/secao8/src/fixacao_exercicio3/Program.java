package fixacao_exercicio3;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Estudante estudante = new Estudante();
		
		estudante.nome = sc.nextLine();
		estudante.nota1 = sc.nextDouble();
		estudante.nota2 = sc.nextDouble();
		estudante.nota3 = sc.nextDouble();
		
		System.out.println("FINAL GRADE = " + estudante.somaNotas());
		
		//Ver se passou ou nao
		if (estudante.pontosParaPassar() == 0) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAILED");
			System.out.printf("MISSING %.2f POINTS%n", estudante.pontosParaPassar());
		}
	}

}
