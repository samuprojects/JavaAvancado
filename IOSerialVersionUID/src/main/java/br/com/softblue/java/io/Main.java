package br.com.softblue.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws Exception {
		
		serialize();
		unserialize();
	}
	
	private static void serialize() throws Exception {
		Usuario u = new Usuario();
		u.setId(5);
		u.setNome("Samuel");
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuario.bin"))){
			oos.writeObject(u);
		}
	}
	
	private static void unserialize() throws Exception {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuario.bin"))){
			Usuario u = (Usuario) ois.readObject();
			System.out.println(u);
		}
	}

}
