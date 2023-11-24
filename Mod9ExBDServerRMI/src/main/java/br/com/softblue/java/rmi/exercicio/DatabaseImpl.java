package br.com.softblue.java.rmi.exercicio;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class DatabaseImpl extends UnicastRemoteObject implements Database {
	
	private Map<String, String> data = new HashMap<String, String>();

	protected DatabaseImpl() throws RemoteException {
	}

	@Override
	public void insertOrUpdate(String key, String value) throws RemoteException {
		data.put(key, value);
		System.out.println("Dado inserido/atualizado");
	}

	@Override
	public String get(String key) throws RemoteException {
		return data.get(key);
	}

	@Override
	public void delete(String key) throws RemoteException {
		data.remove(key);
		System.out.println("Dado removido");
	}

	@Override
	public List<String> getValues() throws RemoteException {
		return new ArrayList<String>(data.values());
	}

}
