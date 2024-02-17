package br.com.softblue.java.xml.exercicio;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Aplicacao {
	
	public static void main(String[] args) throws Exception {
		
		Produto p1 = new Produto("Produto 1", 2, 100.5, false);
		XMLWriter.write(p1, new FileOutputStream("produto_1.xml"));
		
		Produto p2 = new Produto("Produto 2", 3, 30.25, true);
		XMLWriter.write(p2, new FileOutputStream("produto_2.xml"));
		
		Produto p3 = (Produto) XMLReader.read(new FileInputStream("produto_1.xml"));
		Produto p4 = (Produto) XMLReader.read(new FileInputStream("produto_2.xml"));
		System.out.println(p3);
		System.out.println(p4);
	}

}
