package aula132_MetodosAbstratos.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aula132_MetodosAbstratos.entities.Circle;
import aula132_MetodosAbstratos.entities.Rectangle;
import aula132_MetodosAbstratos.entities.Shape;
import aula132_MetodosAbstratos.entities.enums.Color;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Shape> list = new ArrayList<>();

		System.out.print("Enter the number of shapes: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Shape #" + i + " data:");
			System.out.print("Rectangle or Circle (r/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Color (BLACK/BLUE/RED): ");
			Color color = Color.valueOf(sc.next());
			if (ch == 'r') {
				System.out.print("Width: ");
				double width = sc.nextDouble();
				System.out.print("Height: ");
				double height = sc.nextDouble();
				
				//Shape p = new Rectangle(color, width, height);
				//list.add(p);
				// ---OU----
				list.add(new Rectangle(color, width, height)); // é feito upcasting para shape
			} else {
				System.out.print("Radius: ");
				double radius = sc.nextDouble();
				list.add(new Circle(color, radius));
			}
		}

		System.out.println("SHAPE AREA");
		for (Shape sp : list) {
			System.out.println(String.format("%.2f", sp.area()));
		}

		sc.close();
	}

}
