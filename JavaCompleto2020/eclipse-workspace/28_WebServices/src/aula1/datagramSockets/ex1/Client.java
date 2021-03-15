package aula1.datagramSockets.ex1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client {

	public static void main(String[] args) throws SocketException, UnknownHostException, IOException{
		DatagramSocket ds = new DatagramSocket(2000);
        InetAddress ip = InetAddress.getByName("127.0.0.1");

        while (!ds.isClosed()) {
            String mensagem = JOptionPane.showInputDialog("Digite..");
            String str = mensagem + "";
            if (str.equalsIgnoreCase("null")) {
                System.out.println("Fim do cliente!");
                System.out.println("Mensagem a enviar:" + str);
                DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 1000);
                ds.send(dp);
                ds.close();
            } else {
                System.out.println("Mensagem a enviar:" + str);
                DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 1000);
                ds.send(dp);
                System.out.println("Enviado!");

                byte[] bt = new byte[1024];
                DatagramPacket ddp = new DatagramPacket(bt, 1024);
                ds.receive(ddp);
                String recebe = new String(ddp.getData(), 0, ddp.getLength());

                System.out.println("Mensagem vinda do servidor:" + recebe);
            }

        }
	}

}
