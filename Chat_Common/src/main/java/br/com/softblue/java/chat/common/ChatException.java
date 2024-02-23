package br.com.softblue.java.chat.common;

public class ChatException extends Exception {
	
	private static final long serialVersionUID = 8215541578320933119L;

	public ChatException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChatException(String message) {
		super(message);
	}
	
	

}
