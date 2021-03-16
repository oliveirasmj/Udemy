package aula2.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import aula2.Interface.InterfaceSaudacao;

public class Saudacao extends UnicastRemoteObject implements InterfaceSaudacao{
	
	private static final long serialVersionUID = 1L;
	
	static int visitas = 0;

	public Saudacao() throws RemoteException 
	{	
	}
	
	@Override
	public String saudacao(String nome) throws RemoteException {
		visitas();
		return "Bom dia " + nome;
	}

	@Override
	public int visitas() throws RemoteException {
		visitas ++;
		return visitas;
	}

}
