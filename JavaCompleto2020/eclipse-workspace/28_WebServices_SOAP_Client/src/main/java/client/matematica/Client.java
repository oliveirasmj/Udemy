package client.matematica;

public class Client {

	public static void main(String[] args) {
		MatematicaService ms = new MatematicaService();
		Matematica m = ms.getMatematicaPort();
		System.out.println(m.fatorial(5));
		System.out.println(m.maiorPrimo(1, 20));
		System.out.println(m.menorPrimo(1, 20));
		System.out.println(m.soma(1, 20));

	}

}
