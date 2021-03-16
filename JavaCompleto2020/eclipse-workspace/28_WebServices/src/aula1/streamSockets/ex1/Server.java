package aula1.streamSockets.ex1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		// cria o objeto
		ServerSocket s = new ServerSocket(9000, 1); // porto e numero máximo de clientes
		// coloca o servidor à espera de uma tentativa de ligação
		Socket con = s.accept();
		// criar os objetos necessários para a troca de mensagens
		// entre o cliente e servidor
		ObjectInputStream OIS = new ObjectInputStream(con.getInputStream());
		ObjectOutputStream OOS = new ObjectOutputStream(con.getOutputStream());

		while (!s.isClosed()) {
			// ler a mensagem que me enviam
			String r = OIS.readUTF();
			// fecha tudo se clicar no cancelar
			System.out.println("Recebe do cliente:" + r);
			if (r.isEmpty()) {
				System.out.println("Fim do servidor!");
				con.close();
				s.close();
				OIS.close();
				OOS.close();
			} else {
				// Mandar mensagens pro cliente
				// envia ao cliente
				OOS.writeUTF(r);
				// OOS.writeUTF("Servidor->Cliente");
				OOS.flush(); // manda a mensagem
				System.out.println("Servidor reenvia: " + r);
			}

		}

	}
}
