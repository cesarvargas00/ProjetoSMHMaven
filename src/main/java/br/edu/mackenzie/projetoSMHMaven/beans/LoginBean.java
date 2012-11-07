package br.edu.mackenzie.projetoSMHMaven.beans;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.edu.mackenzie.projetoSMHMaven.exception.UserNotFoundException;
import br.edu.mackenzie.projetoSMHMaven.model.Usuario;
import br.edu.mackenzie.projetoSMHMaven.repositorios.UsuarioRepositorio;
import br.edu.mackenzie.projetoSMHMaven.util.SessaoUsuario;
import br.edu.mackenzie.projetoSMHMaven.util.Util;

@ManagedBean
public class LoginBean {
	private String login ;
	private String pass ;

	public String autentica() {
		UsuarioRepositorio repo = new UsuarioRepositorio() ;
		SessaoUsuario sessaoUsuario = new SessaoUsuario() ;
		String passwordMd5 = Util.MD5( this.pass ) ;
		
		Usuario usuario;
		try {
			usuario = repo.login( this.login , passwordMd5 );
			sessaoUsuario.login( usuario ) ;
			return "/home" ;
			
		} catch (UserNotFoundException e) {
			FacesMessage fm = new FacesMessage("usuário e/ou senha inválidos");
			FacesContext fc = FacesContext.getCurrentInstance();
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(null, fm);
			return "/login";
		}
	}

	public String registraSaida() {
		SessaoUsuario sessaoUsuario = new SessaoUsuario() ;
		sessaoUsuario.logout() ;
		return "/login";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
