package br.com.softblue.java.xml.exercicio;

public class Produto {
	
	private String nome;
	private int categoria;
	private double valor;
	private boolean vendido;
	
	public Produto() {
	}

	public Produto(String nome, int categoria, double valor, boolean vendido) {
		this.nome = nome;
		this.categoria = categoria;
		this.valor = valor;
		this.vendido = vendido;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", categoria=" + categoria + ", valor=" + valor + ", vendido=" + vendido + "]";
	}
}
