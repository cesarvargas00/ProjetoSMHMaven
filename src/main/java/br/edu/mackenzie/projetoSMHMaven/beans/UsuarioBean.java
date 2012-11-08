package br.edu.mackenzie.projetoSMHMaven.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.mackenzie.projetoSMHMaven.model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean {
	
	private Usuario user ;
	
	private Boolean isLogged ;

}
