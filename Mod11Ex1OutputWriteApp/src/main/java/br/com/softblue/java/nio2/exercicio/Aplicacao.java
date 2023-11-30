package br.com.softblue.java.nio2.exercicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
		Path outputFile = Paths.get("text.txt");
		
		String lineSeparator = System.getProperty("line.separator");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Digite seu texto =>");
		
		try (BufferedWriter writer = Files.newBufferedWriter(outputFile, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
			
			while (true) {
				String line = reader.readLine();	
				
				if (line.isEmpty()) {
					break;
				}
				
				writer.write(line);
				
				writer.write(lineSeparator);
			}
		}
		
		System.out.println("Dados no arquivo: ");
		
		List<String> lines = Files.readAllLines(outputFile);
		
		for (String line : lines) {
			System.out.println(line);
		}
	}

}
