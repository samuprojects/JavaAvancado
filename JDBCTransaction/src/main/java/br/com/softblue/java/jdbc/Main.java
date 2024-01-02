package br.com.softblue.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:mysql://localhost/softblue";

		try (Connection conn = DriverManager.getConnection(url, "sam", "SsZZ4#2Ao#qEoz")) {
			System.out.println("Conectou no banco de dados");

			String sql1 = "INSERT INTO produto (id, nome) VALUES (?,?)";
			String sql2 = "INSERT INTO item (produto_id, preco) VALUES (?, ?)";
			
			try (PreparedStatement stmt1 = conn.prepareStatement(sql1);
				 PreparedStatement stmt2 = conn.prepareStatement(sql2)) {
				
				conn.setAutoCommit(false);
				
				stmt1.setInt(1, 1);
				stmt1.setString(2, "Feijão");
				stmt1.executeUpdate();
				
				stmt2.setInt(1, 1);
				stmt2.setDouble(2, 3.5);
				stmt2.executeUpdate();
				
				stmt2.setInt(1, 1);
				stmt2.setDouble(2, 4.7);
				stmt2.executeUpdate();
				
				conn.commit();
			}
		}
	}
}