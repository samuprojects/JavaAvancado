package br.com.softblue.java.chat.client.business;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.com.softblue.java.chat.common.rmi.ClientCallback;

public class ClientCallbackImpl extends UnicastRemoteObject implements ClientCallback {

	private static final long serialVersionUID = 4154814840148907675L;

	private ServerRequestHandler handler;
	
	private ServerInvoker serverInvoker;

	public ClientCallbackImpl(ServerRequestHandler handler, ServerInvoker serverInvoker) throws RemoteException {
		this.handler = handler;
		this.serverInvoker = serverInvoker;
	}
	
	@Override
	public void onIncomingMessage(String message) throws RemoteException {
		handler.onMessageReceived(message);
	}
	
	@Override
	public void onServerShutdown() throws RemoteException {

		handler.onServerShutdown();
		
		serverInvoker.setConnected(false);
	}
	
	
}
