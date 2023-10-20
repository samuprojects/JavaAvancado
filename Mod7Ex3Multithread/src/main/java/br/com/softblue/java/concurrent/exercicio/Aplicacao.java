package br.com.softblue.java.concurrent.exercicio;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Aplicacao {

	public static void main(String[] args) {
		
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Buffer buffer = new Buffer();
		
		Produtor p = new Produtor(100, buffer);
		
		executor.execute(p);
		
		Consumidor c = new Consumidor(100, buffer);
		
		executor.execute(c);
		
		executor.shutdown();
	}

}
