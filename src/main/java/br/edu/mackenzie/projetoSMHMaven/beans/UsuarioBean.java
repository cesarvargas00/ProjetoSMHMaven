package br.edu.mackenzie.projetoSMHMaven.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.mackenzie.projetoSMHMaven.model.Usuario;
import br.edu.mackenzie.projetoSMHMaven.util.SessaoUsuario;

@ManagedBean
@SessionScoped
public class UsuarioBean {
	
	/**
	 * @return the user
	 */
	public Usuario getUser() {
		return SessaoUsuario.getInstance().getUser() ;
	}

	/**
	 * @return the isLogged
	 */
	public Boolean getIsLogged() {
		return SessaoUsuario.getInstance().isLogged() ;
	}
	
	public String login() {
		return "/login.xhtml" ;
	}
	
	public String logout() {
		SessaoUsuario.getInstance().logout() ;
		return "/index.xhtml" ;
	}

}