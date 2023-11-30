package br.com.softblue.java.nio2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Path dir = Paths.get("/tmp/curso");
		
//		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.tx?")) {
//			for (Path path : stream) {
//				System.out.println(path);
//		}
		
//		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, p -> Files.size(p) > 100)) {
//			for (Path path : stream) {
//				System.out.println(path);
//			}
//		}
		
		SearchFile searchFile = new SearchFile("txt");
		Files.walkFileTree(dir, searchFile);
		
		System.out.println("--------------------------------");
		
		SearchFile2 searchFile2 = new SearchFile2("txt");
		Files.walkFileTree(dir, searchFile2);
		
	}

}
