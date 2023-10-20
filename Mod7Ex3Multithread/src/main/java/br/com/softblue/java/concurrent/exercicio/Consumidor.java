package br.com.softblue.java.concurrent.exercicio;

public class Consumidor implements Runnable {
	
	private int qtdeItens;
	
	private Buffer buffer;

	public Consumidor(int qtdeItens, Buffer buffer) {
		this.qtdeItens = qtdeItens;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		
		for (int i = 1; i <= qtdeItens; i++) {
			buffer.remover();
			
			int tempo = (int) (Math.random() * 500);
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
