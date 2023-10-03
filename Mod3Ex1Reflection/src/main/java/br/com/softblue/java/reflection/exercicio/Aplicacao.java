package br.com.softblue.java.reflection.exercicio;

public class Aplicacao {
	
	/*
	 * A integração entre annotations e a Reflection API é bastante utilizada na criação de frameworks 
	 * e APIs para serem utilizadas por desenvolvedores. A ideia deste exercício é a criação de um framework simplificado 
	 * que permite a criação de objetos e a invocação automática de métodos de acordo com as anotações presentes no mesmo
	 * de acordo com as regras transmitidas pelo professor.
	 * */
	

	public static void main(String[] args) {
		
		Calculadora calc = ObjectCreator.create(Calculadora.class);
		
		int soma = calc.somar();
		
		System.out.println(soma);
	}

}
