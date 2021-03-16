package aula2.Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import aula2.Interface.InterfaceSaudacao;

public class Server {

	public static void main(String[] args) {
		
		try {
			LocateRegistry.createRegistry(1099);
			InterfaceSaudacao objRemote = new Saudacao();
			Naming.rebind("SaudacaoRemota", objRemote); //Naming - forma de aceder ao RMIRegistry
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
}