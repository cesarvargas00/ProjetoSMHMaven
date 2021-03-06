package br.edu.mackenzie.projetoSMHMaven.repositorios;

import java.util.List ;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.mackenzie.projetoSMHMaven.exception.UserNotFoundException;
import br.edu.mackenzie.projetoSMHMaven.model.Usuario;

public class UsuarioRepositorio extends Repositorio {
	
	public UsuarioRepositorio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioRepositorio(Boolean useFactory) {
		super(useFactory);
		// TODO Auto-generated constructor stub
	}

	public void persistir( Usuario usuario ) {
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
		query.setParameter( "email" , email.trim() ) ;
		
		try {
			usuario = (Usuario) query.getSingleResult() ;
		}
		catch ( NoResultException e ) {
			System.out.println("Nao encontrado...");
		}
		
		if ( usuario != null ) {
			return usuario ;
		}
		
		throw new UserNotFoundException() ;
	}
	
	public Boolean emailExists( String email ) {
		EntityManager manager = this.getManager() ;
		
		Query query = manager.createQuery( "SELECT u FROM Usuario u WHERE email = :email" ) ;
		query.setParameter( "email" , email.trim() ) ;
		
		return query.getResultList().size() > 0 ;
	}
}
