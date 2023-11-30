package br.com.softblue.java.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/*
		Path p1 = Paths.get("/tmp/arq.txt");
		Path p2 = Paths.get("/", "tmp", "arq.txt");
		
		System.out.println(p1);
		System.out.println(p2);
		
		Path p3 = Paths.get("myfile.ini");
		System.out.println(p3);
		
		Path p4 = Paths.get("/", "tmp");
		System.out.println(p4);
		
		Path p5= p4.resolve(p3);
		System.out.println(p5);
		
		Path p = Paths.get("/", "tmp", "arq.txt");
		System.out.println(p.getFileName());
		System.out.println(p.getRoot());
		System.out.println(p.getNameCount());
		System.out.println(p.getName(0));
		*/
		
		//Path p1 = Paths.get("/tmp/curso/texto.txt");
		//Path p2 = Paths.get("/tmp/curso/texto2.txt");
				
		//boolean exists = Files.exists(p);
		//System.out.println(exists);
		
		//Files.copy(p1, p2); // se o arquivo já existe dá erro
		//Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING); // alternativa, cria se não existe, se existe sobrescreve
		
		//Files.delete(p2); // se o arquivo não existe dá erro
		//Files.deleteIfExists(p2); // alternativa, se existe deleta, senão existe não faz nada e não dá erro
		
		//Files.createFile(p2);
		//Files.createTempFile(Paths.get("/tmp/curso/"), "temp_", ".tmp");
		
		//Files.createDirectories(Paths.get("/tmp/curso/dir/dir2/dir3"));
		Path p = Files.createTempDirectory(Paths.get("/tmp/curso"), "tmp");
		System.out.println(p);		
	}

}
