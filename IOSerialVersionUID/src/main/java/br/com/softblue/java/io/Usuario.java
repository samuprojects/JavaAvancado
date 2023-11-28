package br.com.softblue.java.io;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String nomeCompleto; // nome alterado causará null ao desserializar
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nomeCompleto;
	}
	
	public void setNome(String nome) {
		this.nomeCompleto = nome;
	}
	
	@Override
	public String toString() {
		return "Usuário [id=" + id + ", nome = " + nomeCompleto + "]";
	}
	
	public void logar() {
		
	}

}
