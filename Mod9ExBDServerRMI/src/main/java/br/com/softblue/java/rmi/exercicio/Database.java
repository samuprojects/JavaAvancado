package br.com.softblue.java.rmi.exercicio;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Database extends Remote {
	
	void insertOrUpdate(String key, String value) throws RemoteException;
	
	String get (String key) throws RemoteException;
	
	void delete(String key) throws RemoteException;
	
	List<String> getValues() throws RemoteException;
}
