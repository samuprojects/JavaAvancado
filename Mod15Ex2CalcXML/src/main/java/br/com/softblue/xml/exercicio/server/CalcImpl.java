package br.com.softblue.xml.exercicio.server;

import br.com.softblue.xml.exercicio.common.Calc;
import br.com.softblue.xml.exercicio.common.CalcException;

public class CalcImpl implements Calc {

	@Override
	public double somar(double n1, double n2) throws CalcException {
		return n1 + n2;
	}

	@Override
	public double subtrair(double n1, double n2) throws CalcException {
		return n1 - n2;
	}

	@Override
	public double multiplicar(double n1, double n2) throws CalcException {
		return n1 * n2;
	}

	@Override
	public double dividir(double n1, double n2) throws CalcException {
		return n1 / n2;
	}
	
	

}
