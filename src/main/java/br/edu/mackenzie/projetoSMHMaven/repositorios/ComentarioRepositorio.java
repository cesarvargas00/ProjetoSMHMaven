package br.edu.mackenzie.projetoSMHMaven.repositorios;


import br.edu.mackenzie.projetoSMHMaven.model.Comentario;

public class ComentarioRepositorio extends Repositorio {
	
	public ComentarioRepositorio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioRepositorio(Boolean useFactory) {
		super(useFactory);
		// TODO Auto-generated constructor stub
	}

	public void persistir( Comentario comentario ) {
		this.getManager().persist( comentario ) ;
	}
	
}
