package aula1.datagramSockets.ex1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(1000); //porto

        while (!ds.isClosed()) {
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, 1024);
            ds.receive(dp);
            String str = new String(dp.getData(), 0, dp.getLength());
            System.out.println("Recebe do cliente:" + str);
            if (str.equalsIgnoreCase("null")) {
                //System.out.println("Fim do servidor!");
                ds.close();
            } else {
                String mensagem = str;
                System.out.println("Servidor reenvia:" + mensagem);
                InetAddress ip = InetAddress.getByName("127.0.0.1");
                DatagramPacket dd = new DatagramPacket(mensagem.getBytes(), mensagem.length(), ip, 2000);
                ds.send(dd);
            }

        }
	}
}
