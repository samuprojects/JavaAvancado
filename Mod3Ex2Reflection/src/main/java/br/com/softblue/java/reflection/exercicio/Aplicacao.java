package br.com.softblue.java.reflection.exercicio;

import java.util.Calendar;
import java.util.Date;

public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(1980, 7, 10);
		
		Pessoa p = new Pessoa();
		Property.set(p, "nome", "Pedro");
		Property.set(p, "altura", 1.8, double.class);
		Property.set(p, "dataNascimento", calendar.getTime());
		Property.set(p, "numFilhos", 10, int.class);
		
		System.out.println(p);
		
		String nome = Property.get(p, "nome", String.class);
		double altura = Property.get(p, "altura", double.class);
		Date dataNascimento = Property.get(p, "dataNascimento", Date.class);
		int numFilhos = Property.get(p, "numFilhos", int.class);
		
		System.out.println(nome);
		System.out.println(altura);
		System.out.println(dataNascimento);
		System.out.println(numFilhos);

		

	}

}
