package br.com.softblue.xml.exercicio.common;

public interface Calc {

	public double somar (double n1, double n2) throws CalcException;
	
	public double subtrair (double n1, double n2) throws CalcException;
	
	public double multiplicar (double n1, double n2) throws CalcException;
	
	public double dividir (double n1, double n2) throws CalcException;
}
