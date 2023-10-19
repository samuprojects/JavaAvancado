package br.com.softblue.java.concurrent.exercicio;

import java.util.concurrent.Callable;

public class CalculadorParcial implements Callable<Double> {

	private int id;

	public CalculadorParcial(int id) {
		this.id = id;
	}

	@Override
	public Double call() throws Exception {

		double soma = 0;

		for (int i = id; i < Calculador.NUM_ITERACOES; i += Calculador.NUM_THREADS) {
			int s;
			if (i % 2 == 0) {
				s = 1;
			} else {
				s = -1;
			}

			soma += (double) s / (2 * i + 1);
		}
		return soma;
	}

}
