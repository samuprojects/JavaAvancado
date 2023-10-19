package br.com.softblue.java.concurrent.exercicio;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Corrida {
	
	private static final int QTDE_SAPOS = 5;
	
	private static final int DISTANCIA_TOTAL = 500;
	

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(QTDE_SAPOS);
		
		for (int i = 0; i < QTDE_SAPOS; i++) {
			executor.execute(new Sapo("Sapo_" + (i + 1), DISTANCIA_TOTAL));
		}
		
		executor.shutdown();
	}
}
