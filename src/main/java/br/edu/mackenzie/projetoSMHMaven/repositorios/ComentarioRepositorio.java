package br.edu.mackenzie.projetoSMHMaven.repositorios;


import br.edu.mackenzie.projetoSMHMaven.model.Comentario;

public class ComentarioRepositorio extends Repositorio {
	
	public void persistir( Comentario comentario ) {
		this.getManager().persist( comentario ) ;
	}
	
}
