package client.datahora;

public class Client {

	public static void main(String[] args) {
		DataHoraService dhs = new DataHoraService();
		DataHora dh = dhs.getDataHoraPort();
		System.out.println(dh.sayDataHora("HH:mm:ss"));
	}

}
