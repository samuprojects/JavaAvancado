package br.com.softblue.java.concurrent.exercicio;

import java.util.concurrent.RecursiveTask;

@SuppressWarnings("serial")
public class FiboTask extends RecursiveTask<Long>{
	
	private int n;

	public FiboTask(int n) {
		this.n = n;
	}

	@Override
	protected Long compute() {
		
		if (n < 5) {
			return fibonacci(n);
		}
		
		FiboTask task1 = new FiboTask(n - 2);
		FiboTask task2 = new FiboTask(n - 1);
		
		task1.fork();
		
		long task2result = task2.compute();
		
		long task1Result = task1.join();
		
		return task1Result + task2result;
	}
	
	private long fibonacci (int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacci(n - 2) + fibonacci(n -1);
	}

}
