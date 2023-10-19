package br.com.softblue.java.concurrent.exercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Calculador {

	public static final int NUM_THREADS = 10;

	public static final int NUM_ITERACOES = 100000000;

	public static void main(String[] args) throws Exception {

		ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

		List<FutureTask<Double>> tasks = new ArrayList<FutureTask<Double>>();

		long initTime = System.currentTimeMillis();

		for (int i = 0; i < NUM_THREADS; i++) {
			FutureTask<Double> task = new FutureTask<Double>(new CalculadorParcial(i));
			tasks.add(task);
			executor.execute(task);
		}

		double soma = 0;

		for (FutureTask<Double> task : tasks) {
			soma += task.get();
		}

		executor.shutdown();

		double pi = soma * 4;

		long finishTime = System.currentTimeMillis();

		System.out.println("Valor de PI = " + pi);
		System.out.println("Tempo: " + (finishTime - initTime) + "ms");
	}

}
