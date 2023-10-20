package br.com.softblue.java.concurrent.exercicio;

import java.util.concurrent.ForkJoinPool;

public class FiboMain {

	public static void main(String[] args) {
		
		ForkJoinPool pool = new ForkJoinPool();
		
		for (int n = 0; n < 30; n++) {
			
			FiboTask task = new FiboTask(n);
			
			long fibo = pool.invoke(task);
			
			System.out.println(fibo + " ");
		}
	}

}
