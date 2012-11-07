package br.edu.mackenzie.projetoSMHMaven.repositorios;

import javax.persistence.EntityManager;

import br.edu.mackenzie.projetoSMHMaven.model.Post;
import br.edu.mackenzie.projetoSMHMaven.model.Usuario;

public class PostRepositorio extends Repositorio {
	
	public void persistir( Post post ) {
		EntityManager manager = this.getManager() ;
		
		this.getManager().persist( post ) ;
		
		manager.getTransaction().begin() ;
		manager.getTransaction().commit() ;
	}
	
}
