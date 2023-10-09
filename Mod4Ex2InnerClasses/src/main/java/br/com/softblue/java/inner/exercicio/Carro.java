package br.com.softblue.java.inner.exercicio;

public class Carro {
	
	private class Motor {
		
		private boolean ligado;
		
		public void ligar () {
			ligado = true;
			System.out.println("Motor ligado => status " + ligado);
		}
	}
	
	private Motor motor = new Motor();
	
	public void ligarMotor() {
		motor.ligar();
	}
}
