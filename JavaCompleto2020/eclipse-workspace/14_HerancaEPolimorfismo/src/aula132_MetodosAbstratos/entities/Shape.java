package aula132_MetodosAbstratos.entities;

import aula132_MetodosAbstratos.entities.enums.Color;

public abstract class Shape {
	
	private Color color;
	
	public Shape() {
	}
	
	public Shape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public abstract double area(); //Método abstrato - obriga subclasses a usarem o método
}
