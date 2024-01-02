package br.com.softblue.java.jdbc.exercicio.entity;

public enum Categoria {
	
	SOFTWARE('S'),
	MUSICA('M'),
	BACKUP('B');
	
	private char categoria;
	
	private Categoria(char c) {
		this.categoria = c;
	}
	
	public String toString() {
		return String.valueOf(categoria);
	}
	
	public static Categoria getCategoria(char c) {
		for (Categoria categoria : values()) {
			if (categoria.toString().charAt(0) == c) {
				return categoria;
			}
		}
		
		return null;
	}
}
