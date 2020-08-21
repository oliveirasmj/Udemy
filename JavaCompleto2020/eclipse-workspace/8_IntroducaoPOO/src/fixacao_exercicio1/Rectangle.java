package fixacao_exercicio1;

public class Rectangle {

	public double width;
	public double height;

	public double area() {
		return width*height;
	}

	public double perimeter() {
		return width*2+height*2;
	}

	public double diagonal() {
		return Math.sqrt( Math.pow(width, 2) + Math.pow(height, 2) );
		//a^2+b^2 = c^2
		//c = raiz de (a^2 + b^2)
	}
}
