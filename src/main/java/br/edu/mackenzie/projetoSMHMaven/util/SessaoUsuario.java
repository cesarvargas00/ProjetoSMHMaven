package br.edu.mackenzie.projetoSMHMaven.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.edu.mackenzie.projetoSMHMaven.model.Usuario;

public class SessaoUsuario {
	
	private static final String USER_LOGGED_CONTROL = "user_logged" ;
	
	private static final String USER_LOGGED_OBJECT = "user_object" ;
	
	HttpSession httpSession ;
	
	public SessaoUsuario() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		this.httpSession = (HttpSession) ec.getSession( false ) ;
	}
	
	public boolean isLogged() {
		Boolean logado = (Boolean) this.httpSession.getAttribute( USER_LOGGED_CONTROL ) ;
		return logado != null && logado ;
	}
	
	public void logout() {
		this.httpSession.removeAttribute( USER_LOGGED_CONTROL ) ;
		this.httpSession.removeAttribute( USER_LOGGED_OBJECT ) ;
	}
	
	public Usuario getUser() {
		if ( ! this.isLogged() ) {
			return null ;
		}
		
		Usuario usuario = (Usuario) this.httpSession.getAttribute( USER_LOGGED_OBJECT ) ;
		
		return usuario ;
	}
	
	public void login( Usuario usuario ) {
		this.httpSession.setAttribute( USER_LOGGED_CONTROL , true ) ;
		this.httpSession.setAttribute( USER_LOGGED_OBJECT , usuario ) ;
	}
}
