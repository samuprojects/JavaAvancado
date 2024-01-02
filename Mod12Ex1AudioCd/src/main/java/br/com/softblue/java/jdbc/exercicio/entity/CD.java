package br.com.softblue.java.jdbc.exercicio.entity;

public class CD {
	
	private int id;
	private String nome;
	private Categoria categoria;
	private String conteudo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	@Override
	public String toString() {
		return "CD [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", conteudo=" + conteudo + "]";
	}
}
