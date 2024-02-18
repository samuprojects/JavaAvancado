package br.com.softblue.xml.exercicio.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.softblue.xml.exercicio.common.Calc;
import br.com.softblue.xml.exercicio.common.CalcException;
import br.com.softblue.xml.exercicio.common.Request;
import br.com.softblue.xml.exercicio.common.Response;

public class Server {
	
	private Calc calc;
	
	public static void main(String[] args) throws Exception {
		new Server().start();
	}
	
	@SuppressWarnings("resource")
	public void start() throws Exception {
		ServerSocket serverSocket = new ServerSocket(3434);
		
		calc = new CalcImpl();
		
		while (true) {
			
			Socket clientSocket = serverSocket.accept();
			
			DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
			
			String xmlRequest = dis.readUTF();
			
			Request req = Request.fromXML(xmlRequest);
			
			Response resp = invoke(req);
			
			String xmlResponse = resp.toXML();
			
			dos.writeUTF(xmlResponse);
		}		
	}
	
	private Response invoke(Request req) throws CalcException {
		
		double resultado;
		
		switch (req.getOperacao()) {
		case SOMAR:
			resultado = calc.somar(req.getN1(), req.getN2());
			break;
		case SUBTRAIR:
			resultado = calc.subtrair(req.getN1(), req.getN2());
			break;
		case MULTIPLICAR:
			resultado = calc.multiplicar(req.getN1(), req.getN2());
			break;
		case DIVIDIR:
			resultado = calc.dividir(req.getN1(), req.getN2());;
			break;
		default:
			return null;
		}
		
		return Response.fromData(resultado);
	}

}
