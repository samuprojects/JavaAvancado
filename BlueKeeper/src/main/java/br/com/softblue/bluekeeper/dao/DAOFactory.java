package br.com.softblue.bluekeeper.dao;

public class DAOFactory {

	public static SenhaServicoDAO getSenhaServicoDAO() {
		try {
			String daoClass = DAOProperties.getDAOClassName();

			return (SenhaServicoDAO) Class.forName(daoClass).getDeclaredConstructor().newInstance();

		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
			return null;
		}
	}
}
