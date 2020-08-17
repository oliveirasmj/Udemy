package poo_Triangulo;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lado1 = sc.nextInt();
		int lado2 = sc.nextInt();
		int lado3 = sc.nextInt();
		
		Triangle t = new Triangle(lado1, lado2, lado3);
		int valor = t.calcularPerimetro();
		
		System.out.println(valor);
	}

}
