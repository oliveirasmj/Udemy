package aula2.Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import aula2.Interface.InterfaceSaudacao;

public class Client {

	public static void main(String[] args) {
		
		try {
			InterfaceSaudacao s;
			InterfaceSaudacao saudacao = (InterfaceSaudacao) Naming.lookup("rmi://localhost/SaudacaoRemota"); //devolve o objeto remoto (é preciso fazer o cast para InterfaceSaudacao porque retorna remote)
			if(saudacao instanceof InterfaceSaudacao) {
				s = (InterfaceSaudacao) saudacao;
				System.out.println(s.visitas());
				System.err.println(s.saudacao("Mike"));
			}
		}
		catch(RemoteException | MalformedURLException | NotBoundException ex) {
			ex.printStackTrace();
		}
		
	}
}
