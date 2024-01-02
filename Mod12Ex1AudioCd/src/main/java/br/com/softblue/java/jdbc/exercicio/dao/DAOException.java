package br.com.softblue.java.jdbc.exercicio.dao;

@SuppressWarnings("serial")
public class DAOException extends Exception {
	
	public DAOException() {
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}
	
	

}
