package br.com.softblue.java.socket.exercicio.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import br.com.softblue.java.socket.exercicio.util.Console;

public class ChatClient {
	
	@SuppressWarnings("resource")
	public void start(String server, int port) throws IOException {
		
		System.out.println("Digite o seu apelido: ");
		String nick = Console.readString();
		
		System.out.println("Conectando no servidor " + server + ":" + port + "...");
		Socket socket = new Socket(server, port);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream writer = new PrintStream(socket.getOutputStream());
		
		writer.println("connect " + nick);
		
		String response = reader.readLine();
		
		if (response.equals("OK")) {
			System.out.println("O servidor autorizou a conexão. Cliente conectado!");
			MessageListener listener = new MessageListener(reader);
			listener.start();
			
			while (true) {
				String message = Console.readString();
				
				writer.println(message);
				
				if (message.equalsIgnoreCase("[q]")) {
					listener.setStop(true);
					break;
				}
			}
		} else {
			System.out.println("O servidor respondeu: " + response + ". O cliente não pode continuar");
		}
	}
	
	public static void main(String[] args) throws Exception {
		ChatClient server = new ChatClient();
		server.start("localhost", 5000); // verificar
	}

}
