package br.edu.mackenzie.projetoSMHMaven.repositorios;

import br.edu.mackenzie.projetoSMHMaven.model.AndroidSession;

public class AndroidSessionRepositorio extends Repositorio {
	
	public AndroidSessionRepositorio() {
		super() ;
	}
	
	public AndroidSessionRepositorio(boolean b) {
		super(b) ;
	}

	public void persistir( AndroidSession androidSession ) {
		this.getManager().persist( androidSession ) ;
	}


}
