package br.com.softblue.java.reflection.exercicio;

public class Calculadora {
	
	private int n1;
	private int n2;
	
	@Init(runOnInstantiation = true)
	public void init() {
		this.n1 = 10;
		this.n2 = 20;
	}
	
	public int somar() {
		return n1 + n2;
	}

}
