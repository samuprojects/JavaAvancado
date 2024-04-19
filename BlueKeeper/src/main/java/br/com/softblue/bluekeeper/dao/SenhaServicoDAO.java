package br.com.softblue.bluekeeper.dao;

import java.util.Base64;
import java.util.List;

import br.com.softblue.bluekeeper.model.SenhaServico;
import br.com.softblue.bluekeeper.util.CryptoException;
import br.com.softblue.bluekeeper.util.CryptoUtils;

public interface SenhaServicoDAO {

	final byte[] SECRET_KEY = "LDJGOGDLKJFSDYFK".getBytes();

	List<SenhaServico> load();

	void store(List<SenhaServico> senhasServico);

	List<SenhaServico> filter(String text);

	public int generateId();

	default String encrypt(String senha) {

		try {
			byte[] encBytes = CryptoUtils.encryptAES(SECRET_KEY, senha.getBytes());

			byte[] base64Bytes = Base64.getEncoder().encode(encBytes);

			return new String(base64Bytes);

		} catch (Exception e) {
			throw new CryptoException(e);
		}
	}

	default String decrypt(String senha) {
		try {
			byte[] base64Bytes = senha.getBytes();

			byte[] encBytes = Base64.getDecoder().decode(base64Bytes);

			byte[] decBytes = CryptoUtils.decryptAES(SECRET_KEY, encBytes);

			return new String(decBytes);

		} catch (Exception e) {
			throw new CryptoException(e);
		}
	}

}
