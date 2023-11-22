package br.com.softblue.java.sockets.exercicio;

@SuppressWarnings("serial")
public class HTTPServerException extends Exception {
	
	public HTTPServerException() {
	}
	
	public HTTPServerException (String message, Throwable t) {
		super(message, t);
	}
	
	public HTTPServerException (String message) {
		super (message);
	}

	public HTTPServerException(Throwable t) {
		super(t);
	}
	
	

}
