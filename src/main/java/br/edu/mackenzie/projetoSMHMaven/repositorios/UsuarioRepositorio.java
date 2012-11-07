package br.edu.mackenzie.projetoSMHMaven.repositorios;

import java.util.List ;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	
	public Boolean login( String email , String passwordMd5 ) {
		EntityManager manager = this.getManager() ;
		
		Query query = manager.createQuery( "SELECT u FROM Usuario u WHERE email = :email and password = :password" ) ;
		query.setParameter( "password" , passwordMd5 ) ;
		query.setParameter( "email" , email ) ;
		
		System.out.println("Email : " + email + " senha: " + passwordMd5 );
		
		try {
			Usuario usuario = (Usuario) query.getSingleResult() ;			
			if ( usuario != null ) {
				return true ;
			}
		}
		catch ( NoResultException e ) {
			
		}
		
		return false ;
	}
	
}
