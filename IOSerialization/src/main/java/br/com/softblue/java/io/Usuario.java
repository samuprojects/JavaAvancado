package br.com.softblue.java.io;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private Endereco endereco;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Endereco getEndereço() {
		return endereco;
	}
	
	public void setEndereço(Endereco endereço) {
		this.endereco = endereço;
	}
	
	@Override
	public String toString() {
		return "Usuário [id=" + id + ", nome = " + nome + ", endereço = " + endereco + "]";
	}

}
