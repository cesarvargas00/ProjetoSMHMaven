package br.edu.mackenzie.projetoSMHMaven.beans;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class LoginBean {
	private String login;
	private String pass;
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
