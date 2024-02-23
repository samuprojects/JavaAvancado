package br.com.softblue.java.chat.client.business;

public interface ServerRequestHandler {
	
	void onServerShutdown();
	
	void onMessageReceived(String message);
}
