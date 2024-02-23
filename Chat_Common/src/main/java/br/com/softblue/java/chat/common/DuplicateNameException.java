package br.com.softblue.java.chat.common;

public class DuplicateNameException extends ChatException {

	private static final long serialVersionUID = -1242126712090813719L;
	
	public DuplicateNameException(String message) {
		super(message);
	}
}
