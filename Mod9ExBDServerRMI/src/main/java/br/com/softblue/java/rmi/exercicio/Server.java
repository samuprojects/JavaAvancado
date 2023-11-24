package br.com.softblue.java.rmi.exercicio;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) throws Exception {
		
		Database database = new DatabaseImpl();
		
		Registry registry = LocateRegistry.createRegistry(1099);
		
		registry.rebind("db", database);
		
		System.out.println("Servidor iniciado");
		
	}

}
