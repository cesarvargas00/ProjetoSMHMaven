package br.edu.mackenzie.projetoSMHMaven.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.mackenzie.projetoSMHMaven.model.Usuario;
import br.edu.mackenzie.projetoSMHMaven.repositorios.UsuarioRepositorio;
import br.edu.mackenzie.projetoSMHMaven.util.SessaoUsuario;

@ManagedBean
@SessionScoped
public class UsuarioBean {
	private Usuario usuario;
	
	public UsuarioBean() {
		this.usuario = new Usuario();
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

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
	
	public String editUser(){
		this.usuario = SessaoUsuario.getInstance().getUser();
		return "/admin/conta";
	}

	public String salvar(){
		UsuarioRepositorio repo = new UsuarioRepositorio();
		this.usuario.setPasswordMD5(this.usuario.getPassword());
		repo.merge(this.usuario);
		
		return "/index.xhtml";
	}
}