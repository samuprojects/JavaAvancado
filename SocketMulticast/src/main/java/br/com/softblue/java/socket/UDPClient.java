package br.com.softblue.java.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) throws Exception {
		
		try (DatagramSocket socket = new DatagramSocket()) {
			
			String str = "Olá, bem-vindo ao sistema!";
			
			byte[] buffer = str.getBytes();
			
			InetAddress addr = InetAddress.getByName("228.5.6.7");
			
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, addr, 2500);
			socket.send(packet);
			System.out.println("Cliente informa: foi enviado para o servidor o texto ==> " + str);
		}
	}

}
