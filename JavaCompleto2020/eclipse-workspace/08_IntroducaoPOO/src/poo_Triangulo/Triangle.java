package poo_Triangulo;

public class Triangle {
	
	private int lado1;
	private int lado2;
	private int lado3;
	
	public Triangle(int lado1, int lado2, int lado3) {
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}

	public int calcularPerimetro() {
		return lado1 + lado2 + lado3;
	}
}
