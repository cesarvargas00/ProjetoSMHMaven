package br.edu.mackenzie.projetoSMHMaven.beans;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.edu.mackenzie.projetoSMHMaven.repositorios.UsuarioRepositorio;
import br.edu.mackenzie.projetoSMHMaven.util.Util;

@ManagedBean
public class LoginBean {
	private String login ;
	private String pass ;

	public String autentica() {
		FacesContext fc = FacesContext.getCurrentInstance();
		
		UsuarioRepositorio repo = new UsuarioRepositorio() ;
		
		String passwordMd5 = Util.MD5( this.pass ) ;
		
		if ( repo.login( this.login , passwordMd5 ) ) {
			ExternalContext ec = fc.getExternalContext();
			HttpSession session = (HttpSession) ec.getSession(false);
			session.setAttribute( "user", this.login ) ;
			return "/home" ;
		}
		else {
			FacesMessage fm = new FacesMessage("usuário e/ou senha inválidos");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(null, fm);
			return "/login";
		}
	}

	public String registraSaida() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		session.removeAttribute("user");
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
