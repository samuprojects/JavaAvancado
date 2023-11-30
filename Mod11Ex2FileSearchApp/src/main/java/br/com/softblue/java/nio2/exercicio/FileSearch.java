package br.com.softblue.java.nio2.exercicio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FileSearch {
	
	private Path foundFile;
	
	public Path search(String fileName, String startDir) throws IOException {
		
		Path path = Paths.get(startDir);
		
		if (!Files.exists(path)) {
			throw new IOException("O diretório " + path + " não existe");
		}
		
		SearchVisitor visitor = new SearchVisitor(Paths.get(fileName));
		
		Files.walkFileTree(path, visitor);
				
		return foundFile;
	}
	
	private class SearchVisitor implements FileVisitor<Path> {
		
		private Path fileToSearch;
		
		public SearchVisitor (Path fileToSearch) {
			this.fileToSearch = fileToSearch;
		}

		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			System.out.println("Procurando em " + dir);
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			
			if (file.getFileName().toString().equalsIgnoreCase(fileToSearch.toString())) {
				System.out.println("Arquivo encontrado: " + file);
				foundFile = file;
				return FileVisitResult.TERMINATE;
			}
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
			return FileVisitResult.CONTINUE;
		}		
	}
}
