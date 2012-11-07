package br.edu.mackenzie.projetoSMHMaven.repositorios;

import java.util.List ;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.mackenzie.projetoSMHMaven.model.Usuario;

public class UsuarioRepositorio extends Repositorio {
	
	public void persistir( Usuario usuario ) {
		EntityManager manager = this.getManager() ;
		
		this.getManager().persist( usuario ) ;
		
		manager.getTransaction().begin() ;
		manager.getTransaction().commit() ;
	}
	
	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = null ;
		
		EntityManager manager = this.getManager() ;
		Query query = manager.createQuery( "SELECT u FROM Usuario u" ) ;
		usuarios = query.getResultList() ;
		
		return usuarios ;
	}
	
}
