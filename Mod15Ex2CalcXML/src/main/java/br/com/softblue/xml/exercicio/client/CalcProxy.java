package br.com.softblue.xml.exercicio.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import br.com.softblue.xml.exercicio.common.Calc;
import br.com.softblue.xml.exercicio.common.CalcException;
import br.com.softblue.xml.exercicio.common.Request;
import br.com.softblue.xml.exercicio.common.Request.Op;
import br.com.softblue.xml.exercicio.common.Response;

public class CalcProxy implements Calc {

	private Socket socket;
	
	private DataInputStream dis;
	
	private DataOutputStream dos;
	
	private void initSocket() throws CalcException {
		try {
			socket = new Socket("localhost", 3434);
			
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
		} catch (Exception e) {
			throw new CalcException(e);
		}
	}
	
	private void closeSocket() throws CalcException{
		try {
			
			if (socket != null) {
				socket.close();
			}
		} catch (Exception e) {
			throw new CalcException(e);
		}
	}
	
	private Response invoke(Request req) throws CalcException {
		try {
			System.out.println("Req: " + req.toXML());
			
			dos.writeUTF(req.toXML());
			
			String xmlResponse = dis.readUTF();
			
			System.out.println("Resp: " + xmlResponse);
			
			return Response.fromXML(xmlResponse);
			
		} catch (Exception e) {
			throw new CalcException(e);
		}
	}

	@Override
	public double somar(double n1, double n2) throws CalcException {
		initSocket();
		try {
			Request req = Request.fromData(Op.SOMAR, n1, n2);
			Response resp = invoke(req);
			return resp.getResultado();
			
		} finally {
			closeSocket();
		}
	}

	@Override
	public double subtrair(double n1, double n2) throws CalcException {
		initSocket();
		try {
			Request req = Request.fromData(Op.SUBTRAIR, n1, n2);
			Response resp = invoke(req);
			return resp.getResultado();
			
		} finally {
			closeSocket();
		}
	}

	@Override
	public double multiplicar(double n1, double n2) throws CalcException {
		initSocket();
		try {
			Request req = Request.fromData(Op.MULTIPLICAR, n1, n2);
			Response resp = invoke(req);
			return resp.getResultado();
			
		} finally {
			closeSocket();
		}
	}

	@Override
	public double dividir(double n1, double n2) throws CalcException {
		initSocket();
		try {
			Request req = Request.fromData(Op.DIVIDIR, n1, n2);
			Response resp = invoke(req);
			return resp.getResultado();
			
		} finally {
			closeSocket();
		}
	}	
}
