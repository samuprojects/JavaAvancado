package br.com.softblue.java.chat.common.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote {
	
	public void onIncomingMessage (String message) throws RemoteException;
	
	public void onServerShutdown() throws RemoteException;
}
