package aula2.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceSaudacao extends Remote{

	public String saudacao(String nome) throws RemoteException;
	
	public int visitas() throws RemoteException;
}
