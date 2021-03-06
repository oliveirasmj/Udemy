package aula197_Ex1HerancaSemInterface.model.entities;

import java.awt.Color;

public abstract class Shape {
	
	private Color color;

	public Shape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public abstract double area();
}
