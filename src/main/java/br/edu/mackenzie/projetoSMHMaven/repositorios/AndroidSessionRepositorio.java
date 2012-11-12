package br.edu.mackenzie.projetoSMHMaven.repositorios;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.mackenzie.projetoSMHMaven.exception.UserNotFoundException;
import br.edu.mackenzie.projetoSMHMaven.model.AndroidSession;
import br.edu.mackenzie.projetoSMHMaven.model.Usuario;
import br.edu.mackenzie.projetoSMHMaven.util.Util;

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
	
	public Usuario getByAuthKey( String authKey ) throws UserNotFoundException {
		EntityManager manager = this.getManager() ;
		Usuario usuario = null ;
		Calendar cal = Calendar.getInstance() ;
		
		Query query = manager.createQuery( "SELECT a FROM AndroidSession a WHERE authKey = :authKey and expiration >= :expiration" ) ;
		query.setParameter( "authKey" , authKey ) ;
		query.setParameter( "expiration" , cal ) ;
		
		try {
			AndroidSession session = (AndroidSession) query.getSingleResult() ; 
			usuario = session.getUser() ;
		}
		catch ( NoResultException e ) {
			System.out.println("Nao encontrado...");
		}
		
		if ( usuario != null ) {
			return usuario ;
		}
		
		throw new UserNotFoundException() ;
	}

}
