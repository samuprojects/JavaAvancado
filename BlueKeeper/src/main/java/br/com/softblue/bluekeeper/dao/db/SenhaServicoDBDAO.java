package br.com.softblue.bluekeeper.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.softblue.bluekeeper.dao.DAOException;
import br.com.softblue.bluekeeper.dao.SenhaServicoDAO;
import br.com.softblue.bluekeeper.model.SenhaServico;

public class SenhaServicoDBDAO implements SenhaServicoDAO {

	@Override
	public List<SenhaServico> load() {

		return filter(null);
	}

	@Override
	public void store(List<SenhaServico> senhasServico) {

		try (Connection conn = ConnectionFactory.openConnection()) {

			conn.setAutoCommit(false);

			String deleteSql = "DELETE FROM SENHA_SERVICO";
			try (PreparedStatement stmt = conn.prepareStatement(deleteSql)) {
				stmt.executeUpdate();
			}

			String insertSql = "INSERT INTO SENHA_SERVICO (ID, SERVICO, LOGIN, SENHA, OBSERVACOES) VALUES (?, ?, ?, ?, ?)";
			try (PreparedStatement stmt = conn.prepareStatement(insertSql)) {
				for (SenhaServico senhaServico : senhasServico) {
					stmt.setInt(1, senhaServico.getId());
					stmt.setString(2, senhaServico.getServico());
					stmt.setString(3, senhaServico.getLogin());
					stmt.setString(4, encrypt(senhaServico.getSenha()));
					stmt.setString(5, senhaServico.getObservacoes());
					stmt.executeUpdate();
				}
			}

			conn.commit();

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public List<SenhaServico> filter(String text) {

		try (Connection conn = ConnectionFactory.openConnection()) {
			String sql = "SELECT ID, LOGIN, SENHA, SERVICO, OBSERVACOES FROM SENHA_SERVICO";

			if (text != null) {
				sql += " WHERE UPPER(LOGIN) LIKE ? OR UPPER(SERVICO) LIKE ?";
			}

			try (PreparedStatement stmt = conn.prepareStatement(sql)) {

				if (text != null) {
					String param = "%" + text.toUpperCase() + "%";
					stmt.setString(1, param);
					stmt.setString(2, param);
				}

				try (ResultSet rs = stmt.executeQuery()) {
					List<SenhaServico> senhasServico = new ArrayList<>();

					while (rs.next()) {
						SenhaServico senhaServico = new SenhaServico();
						senhaServico.setId(rs.getInt("ID"));
						senhaServico.setLogin(rs.getString("LOGIN"));
						senhaServico.setSenha(decrypt(rs.getString("SENHA")));
						senhaServico.setServico(rs.getString("SERVICO"));
						senhaServico.setObservacoes(rs.getString("OBSERVACOES"));
						senhasServico.add(senhaServico);
					}

					return senhasServico;
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public int generateId() {
		try (Connection conn = ConnectionFactory.openConnection()) {
			String sql = "SELECT MAX(ID) FROM SENHA_SERVICO";

			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						return rs.getInt(1) + 1;
					}

					return 1;
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
