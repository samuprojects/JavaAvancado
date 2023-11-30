package br.com.softblue.java.nio2.exercicio;

import java.nio.file.Path;

public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
		FileSearch search = new FileSearch();
		
		Path p = search.search("arquivo.txt", "/tmp/curso");
		
		System.out.println(p);
	}

}
