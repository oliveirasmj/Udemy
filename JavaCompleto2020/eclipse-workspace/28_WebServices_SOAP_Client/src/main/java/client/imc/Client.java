package client.imc;

public class Client {

	public static void main(String[] args) {
		IMCService is = new IMCService();
		IMC i = is.getIMCPort();
		System.out.println(i.indice(65, 1.74));
	}

}
