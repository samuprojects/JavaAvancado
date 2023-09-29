package br.com.softblue.java.generics.exercicio;

public class ExApp {

	/*
	 * Exercício Módulo 2
	 * 
	 * Implementar uma classe Map para mapear chaves e valores com tipo parametrizáveis fornecidos na criação do objeto.
	 * A classe deve permitir a recuperação de um valor com base em uma chave.
	 * Deve ter duas listas uma para armazenar o conjunto de chaves e a outra o conjunto de valores ocupando o mesmo índice nas duas listas.
	 * Caso o usuário insira uma chave existente substituir pelo novo valor fornecido.
	 * 
	 * A classe Map deve possuir os métodos públicos:
	 * boolean put(K, V) para retornar true à nova chave adicionada ou false se já existia e o valor da chave foi atualizado;
	 * V get (K) para trazer o valor da chave informada pelo usuário ou null caso não exista.
	 * void clear() para excluir todos os elementos do Map.
	 * */
	
	public static void main(String[] args) {
		
		Map<Integer, String> map = new Map<Integer, String>();
		
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");
		map.put(1, "X");
		
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		System.out.println(map.get(3));
		System.out.println(map.get(4));
		System.out.println(map.get(5));
	}
}
