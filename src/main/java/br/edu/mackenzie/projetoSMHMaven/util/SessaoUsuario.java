package br.edu.mackenzie.projetoSMHMaven.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.edu.mackenzie.projetoSMHMaven.model.Usuario;

/**
 * Gerencia a sessao do usuário, utiliza um singleton
 * @author Alisson
 *
 */
public class SessaoUsuario {
	
	private static final String USER_LOGGED_CONTROL = "user_logged" ;
	
	private static final String USER_LOGGED_OBJECT = "user_object" ;
	
	public static SessaoUsuario sessaoUsuarioInstance ;
	
	HttpSession httpSession ;
		
	private SessaoUsuario( HttpSession session ) {
		this.httpSession = session ;
	}
	
	public boolean isLogged() {
		Boolean logado = (Boolean) this.httpSession.getAttribute( USER_LOGGED_CONTROL ) ;
		System.out.println( "Teste::: " + logado ) ;
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
	
	public static SessaoUsuario getInstance() {
		if ( sessaoUsuarioInstance == null ) {
			FacesContext fc = FacesContext.getCurrentInstance();
			ExternalContext ec = fc.getExternalContext();
			HttpSession httpSession = (HttpSession) ec.getSession( false ) ;
			
			sessaoUsuarioInstance = new SessaoUsuario( httpSession ) ;
		}
		
		return sessaoUsuarioInstance ;
	}
	
	public static SessaoUsuario getInstance( ServletRequest request ) {
		if ( sessaoUsuarioInstance == null ) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			
			sessaoUsuarioInstance = new SessaoUsuario( session ) ;
		}
		
		return sessaoUsuarioInstance ;
	}
}
