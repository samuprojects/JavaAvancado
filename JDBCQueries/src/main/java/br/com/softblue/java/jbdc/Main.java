package br.com.softblue.java.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) throws Exception {

		String[] nomesProdutos = { "Feijão", "Batata", "Cebola", "Tomate" };

		String url = "jdbc:mysql://localhost/softblue";

		try (Connection conn = DriverManager.getConnection(url, "sam", "SsZZ4#2Ao#qEoz")) {
			System.out.println("Conectou no banco de dados");

//			String sql = "INSERT INTO produto (NOME) VALUES ('Arroz')";
//
//			try (Statement stmt = conn.createStatement()) {
//				stmt.executeUpdate(sql);
//				System.out.println("Produto inserido");
//			}

			try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO produto (NOME) VALUES (?)")) {
				for (String nomeProduto : nomesProdutos) {
					stmt.setString(1, nomeProduto);
					stmt.executeUpdate();
				}
			}
		}
	}
}
