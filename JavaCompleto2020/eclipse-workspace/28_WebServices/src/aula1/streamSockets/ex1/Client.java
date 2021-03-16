package aula1.streamSockets.ex1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {

	public static void main(String[] args) throws IOException {
		
		Socket con = new Socket("localhost", 9000);
        ObjectOutputStream OOS = new ObjectOutputStream(con.getOutputStream());
        ObjectInputStream OIS = new ObjectInputStream(con.getInputStream());

        String mensagem = "";

        while (!con.isClosed()) {

            mensagem = JOptionPane.showInputDialog("Digite..");
            if (mensagem == null) {
                mensagem = "";
                OOS.writeUTF(mensagem);
                OOS.flush();
                con.close();
            } else {
                OOS.writeUTF(mensagem);
                OOS.flush();

                System.out.println("Mensagem a enviar:" + mensagem);
                String r = OIS.readUTF();
                System.out.println("Mensagem do servidor: " + r);
            }

        }
	}

}
