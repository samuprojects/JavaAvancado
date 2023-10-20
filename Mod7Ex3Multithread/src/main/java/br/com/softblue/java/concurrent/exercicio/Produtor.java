package br.com.softblue.java.concurrent.exercicio;

public class Produtor implements Runnable {
	
	private int qtdeItens;
	
	private Buffer buffer;

	public Produtor(int qtdeItens, Buffer buffer) {
		this.qtdeItens = qtdeItens;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		
		for (int i = 1; i <= qtdeItens; i++) {
			
			int item = (int) (Math.random() * qtdeItens);
			buffer.inserir(item);
			
			int tempo = (int) (Math.random() * 500);
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
