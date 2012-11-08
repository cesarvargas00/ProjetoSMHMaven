package br.edu.mackenzie.projetoSMHMaven.beans;


import javax.faces.bean.ManagedBean;

import br.edu.mackenzie.projetoSMHMaven.model.Usuario;
import br.edu.mackenzie.projetoSMHMaven.repositorios.UsuarioRepositorio;

@ManagedBean
public class CadastroBean {

	private Usuario usuario;
	
	public CadastroBean() {
		this.usuario = new Usuario();
	}
	
	public void cadastraUsuario(){
		UsuarioRepositorio urep = new UsuarioRepositorio();
		this.usuario.setPasswordMD5(this.usuario.getPassword());
		urep.persistir(this.usuario);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
