package br.com.softblue.java.jdbc.exercicio;

import java.util.List;

import br.com.softblue.java.jdbc.exercicio.dao.CDDAO;
import br.com.softblue.java.jdbc.exercicio.entity.CD;
import br.com.softblue.java.jdbc.exercicio.entity.Categoria;

public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
		CDDAO dao = new CDDAO();
		
		CD cd = new CD();
		cd.setNome("Músicas - Rock Gospel");
		cd.setCategoria(Categoria.MUSICA);
		cd.setConteudo("Coletânea de rock gospel");
		dao.create(cd);
		
		List<CD> cds = dao.findCDsByCategoria(Categoria.MUSICA);
		
		for (CD cdMusica : cds) {
			cdMusica.setConteudo("Músicas em geral");
			dao.update(cdMusica);
		}		
	}
}