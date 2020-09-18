package aula197_Exemplo1SemInterface.application;

import java.awt.Color;

import aula197_Exemplo1SemInterface.model.entities.Circle;
import aula197_Exemplo1SemInterface.model.entities.Rectangle;
import aula197_Exemplo1SemInterface.model.entities.Shape;

public class Program {

	public static void main(String[] args) {

		Shape s1 = new Circle(Color.BLACK, 2.0);
		Shape s2 = new Rectangle(Color.WHITE, 3.0, 4.0);
		
		System.out.println("Circle color: " + s1.getColor());
		System.out.println("Circle area: " + String.format("%.3f", s1.area()));
		System.out.println("Rectangle color: " + s2.getColor());
		System.out.println("Rectangle area: " + String.format("%.3f", s2.area()));
	}
}
