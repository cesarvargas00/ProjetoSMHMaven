package br.edu.mackenzie.projetoSMHMaven.beans;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class LoginBean {
	private String login;
	private String pass;
	private static Map<String, String> mapa = new HashMap<String, String>();
	static {
		LoginBean.mapa.put("cesar.vargas", "senha");
		LoginBean.mapa.put("alisson", "senha");
	}

	public String autentica() {
		FacesContext fc = FacesContext.getCurrentInstance();
		if (LoginBean.mapa.containsKey(this.login)
				&& LoginBean.mapa.get(this.login).equals(this.pass)) {
			ExternalContext ec = fc.getExternalContext();
			HttpSession session = (HttpSession) ec.getSession(false);
			session.setAttribute("user", this.login);
			return "/home";
		} else {
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
