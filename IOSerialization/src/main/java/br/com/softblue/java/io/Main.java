package br.com.softblue.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws Exception {

		//create();
		
		load();
	}

	@SuppressWarnings("unused")
	private static void create() throws Exception {
		Endereco endereco = new Endereco();
		endereco.setRua("Rua do Limão");
		endereco.setNumero(1200);
		
		Usuario usuario = new Usuario();
		usuario.setId(11);
		usuario.setNome("Samuel");
		usuario.setEndereço(endereco);
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dados.bin"))){
			oos.writeObject(usuario);
		}
	}
	
	private static void load() throws Exception {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dados.bin"))){
			Usuario usuario = (Usuario) ois.readObject();
			System.out.println(usuario);
		}
	}

}
