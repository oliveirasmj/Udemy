package client.escola;

public class Client {

	public static void main(String[] args) {
		EscolaService es = new EscolaService();
		Escola e = es.getEscolaPort();
		System.out.println(e.listarAlunos());
	}

}
