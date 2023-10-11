package br.com.softblue.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	private static List<String> itens = Arrays.asList("computador", "papel", "caneta", "quadro", "borracha", "cortina", "gaveta");

	public static void main(String[] args) {
		
		executar1();
		executar2();
		executar3();
	}
	
	private static void executar1() {

		// Exemplo de como ordenar a lista, manter apenas os 3 primeiros elementos e apresentar na tela
		
		itens.stream()
		.sorted()
		.limit(3)
		.forEach(System.out::println);
	}
	
	private static void executar2() {
		
		// Exemplo de como filtrar apenas os elementos que contenham a letra c e apresentar na tela
		
		List<String> itensFiltrados = itens.stream()
		.filter(e -> e.contains("c"))
		.collect(Collectors.toList());
		
		System.out.println(itensFiltrados);
	}
	
	private static void executar3() {
		
		// Exemplo de como somar a quantidade de caracteres de todos os elementos e apresentar o resultado na tela
		
		int count = itens.stream()
		.collect(Collectors.summingInt(e -> e.length()));
		
		System.out.println(count);
	}

}
