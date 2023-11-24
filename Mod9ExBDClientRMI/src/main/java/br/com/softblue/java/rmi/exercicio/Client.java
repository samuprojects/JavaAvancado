package br.com.softblue.java.rmi.exercicio;

import java.rmi.Naming;
import java.util.List;

public class Client {

	public static void main(String[] args) throws Exception {

		String url = "rmi://localhost:1099/db";

		Database database = (Database) Naming.lookup(url);

		database.insertOrUpdate("nome1", "Samuel");
		database.insertOrUpdate("nome2", "Carlos");
		database.insertOrUpdate("nome3", "André");
		database.insertOrUpdate("nome4", "Tadeu");
		database.insertOrUpdate("nome5", "Celso");

		List<String> values = database.getValues();

		for (String value : values) {
			System.out.println(value);
		}
		
		database.delete("nome3");

		System.out.println("Dados após exclusão: " + database.getValues());
	}

}
