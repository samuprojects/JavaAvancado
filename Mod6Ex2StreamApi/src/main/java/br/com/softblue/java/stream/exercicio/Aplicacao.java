package br.com.softblue.java.stream.exercicio;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Aplicacao {
	
	private static int currentId = 1;

	public static void main(String[] args) {
		
		List<String> cores = Arrays.asList("Azul", "Branco", "Preto", "Amarelo", "Azul");
		
		List<Papel> papeis = cores.stream()
				.map(c -> new Papel(currentId++, Papel.Cor.valueOf(c)))
				.collect(Collectors.toList());
		
		papeis.forEach(p -> System.out.println(p.getId() + " -> " + p.getCor()));		
	}

}
