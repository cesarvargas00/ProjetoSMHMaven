package br.edu.mackenzie.projetoSMHMaven.repositorios;

import java.util.List ;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.mackenzie.projetoSMHMaven.exception.UserNotFoundException;
import br.edu.mackenzie.projetoSMHMaven.model.Admin;
import br.edu.mackenzie.projetoSMHMaven.model.Usuario;

public class UsuarioRepositorio extends Repositorio {
	
	public void persistir( Usuario usuario ) {
		EntityManager manager = this.getManager() ;
		
		this.getManager().persist( usuario ) ;
	}
	
	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = null ;
		
		EntityManager manager = this.getManager() ;
		Query query = manager.createQuery( "SELECT u FROM Usuario u" ) ;
		usuarios = query.getResultList() ;
		
		return usuarios ;
	}
	
	public Usuario login( String email , String passwordMd5 ) throws UserNotFoundException {
		EntityManager manager = this.getManager() ;
		Usuario usuario = null ;
		
		Query query = manager.createQuery( "SELECT u FROM Usuario u WHERE email = :email and password = :password" ) ;
		query.setParameter( "password" , passwordMd5 ) ;
		query.setParameter( "email" , email ) ;
		
		try {
			usuario = (Usuario) query.getSingleResult() ;
		}
		catch ( NoResultException e ) {
			
		}
		
		if ( usuario != null ) {
			return usuario ;
		}
		
		throw new UserNotFoundException() ;
	}
	
}
