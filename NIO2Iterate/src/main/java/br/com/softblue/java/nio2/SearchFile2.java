package br.com.softblue.java.nio2;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;

public class SearchFile2 extends SimpleFileVisitor<Path> {

	private String fileName2;

	public SearchFile2(String fileName) {
		this.fileName2 = fileName;

	}

	public FileVisitResult visitFile(Path file, java.nio.file.attribute.BasicFileAttributes attrs)
			throws java.io.IOException {
		System.out.println("Acessando o arquivo " + file);

		if (file.getFileName().toString().contains(fileName2)) {
			System.out.println("Arquivo encontrado em " + file);
			return FileVisitResult.TERMINATE;
		}
		return FileVisitResult.CONTINUE;
	}
}