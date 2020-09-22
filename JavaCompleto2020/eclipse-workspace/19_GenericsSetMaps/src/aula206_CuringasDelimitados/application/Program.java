package aula206_CuringasDelimitados.application;

import java.util.ArrayList;
import java.util.List;

import aula206_CuringasDelimitados.entities.Circle;
import aula206_CuringasDelimitados.entities.Rectangle;
import aula206_CuringasDelimitados.entities.Shape;

public class Program {

	public static void main(String[] args) {
		
		List<Shape> myShapes = new ArrayList<>();
		myShapes.add(new Rectangle(3.0, 2.0)); //Shape s = new Rectangle(3.0, 2.0); myShapes.add(s);
		myShapes.add(new Circle(2.0));
		System.out.println("Total area: " + totalArea(myShapes));
		
		
		List<Circle> myCircles = new ArrayList<>();
		myCircles.add(new Circle(2.0));
		myCircles.add(new Circle(3.0));
		System.out.println("Total area: " + totalArea(myCircles));
	}
	
//	//só funciona para listar Shapes
//	public static double totalArea(List<Shape> list) {
//		double sum = 0;
//		for(Shape s : list) {
//			sum += s.area();
//		}
//		return sum;
//	}
	
	//consegue listar todos
	public static double totalArea(List<? extends Shape> list) { //aqui já é possível listar todos os tipos - lista de qualquer tipo que seja um subtipo de shape
		double sum = 0;
		for(Shape s : list) {
			sum += s.area(); 
		}
		return sum;
		//list.add(new Rectangle(3.0, 4.0)); //NÃO É POSSÍVEL ADICIONAR - APENAS LISTAR - porque a lista genérica pode ser de um tipo diferente e neste caso é um retangulo
	}
	
}