package br.com.softblue.java.chat.common;

import java.io.Serializable;
import java.util.Objects;

import br.com.softblue.java.chat.common.rmi.ClientCallback;

public class ClientInfo implements Serializable {

	private static final long serialVersionUID = -4940321660434497094L;
	
	private String name;
	
	private ClientCallback callback;
	
	public ClientInfo(String name, ClientCallback callback) {
		this.name = name;
		this.callback = callback;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ClientCallback getCallback() {
		return callback;
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(callback, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientInfo other = (ClientInfo) obj;
		return Objects.equals(callback, other.callback) && Objects.equals(name, other.name);
	}

	
	
	
	
	
	

}
