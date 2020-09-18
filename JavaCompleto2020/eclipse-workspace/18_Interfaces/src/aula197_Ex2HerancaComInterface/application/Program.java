package aula197_Ex2HerancaComInterface.application;

import java.awt.Color;

import aula197_Ex2HerancaComInterface.model.entities.AbstractShape;
import aula197_Ex2HerancaComInterface.model.entities.Circle;
import aula197_Ex2HerancaComInterface.model.entities.Rectangle;

public class Program { //Neste exercicio pretende-se que a Classe Shape tenha apenas o metodo area() sem a cor --> Herança com interface

	public static void main(String[] args) {

		AbstractShape s1 = new Circle(Color.BLACK, 2.0);
		AbstractShape s2 = new Rectangle(Color.WHITE, 3.0, 4.0);
		
		System.out.println("Circle color: " + s1.getColor());
		System.out.println("Circle area: " + String.format("%.3f", s1.area()));
		System.out.println("Rectangle color: " + s2.getColor());
		System.out.println("Rectangle area: " + String.format("%.3f", s2.area()));
	}
}
