package br.edu.mackenzie.projetoSMHMaven.beans;


import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.mackenzie.projetoSMHMaven.model.Usuario;
import br.edu.mackenzie.projetoSMHMaven.repositorios.UsuarioRepositorio;

@ManagedBean
public class CadastroBean {

	private Usuario usuario;
	
	private String senhaConf ;
	
	public CadastroBean() {
		this.usuario = new Usuario();
	}
	
	public String cadastraUsuario(){
		UsuarioRepositorio urep = new UsuarioRepositorio();
		
		// Validações
		if ( this.usuario.getFirstName().trim().equals( "" ) ) { 
			this.addMessage( "Primeiro nome em branco" , FacesMessage.SEVERITY_WARN ) ;
			return "novoUser" ;
		}
		
		if ( this.usuario.getLastName().trim().equals( "" ) ) { 
			this.addMessage( "Último nome em branco" , FacesMessage.SEVERITY_WARN ) ;
			return "novoUser" ;
		}
		
		Pattern patt = Pattern.compile( "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$" ) ;
		if ( ! patt.matcher( this.usuario.getEmail() ).matches() ) {
			this.addMessage( "E-mail inválido" , FacesMessage.SEVERITY_WARN ) ;
			return "novoUser" ;
		}
		
		if ( urep.emailExists( this.usuario.getEmail() ) ) {
			this.addMessage( "E-mail já cadastro no sistema" , FacesMessage.SEVERITY_WARN ) ;
			return "novoUser" ;
		}
		
		if ( this.usuario.getPassword().trim().equals( "" ) ) { 
			this.addMessage( "Senha em branco" , FacesMessage.SEVERITY_WARN ) ;
			return "novoUser" ;
		}
		
		if ( ! this.usuario.getPassword().equals( this.senhaConf ) ) {
			this.addMessage( "Senha e Confirmação diferentes" , FacesMessage.SEVERITY_WARN ) ;
			return "novoUser" ;
		}
		
		this.usuario.setPasswordMD5(this.usuario.getPassword());
		urep.persistir(this.usuario);
		
		this.addMessage( "Usuario cadastrado com sucesso." , FacesMessage.SEVERITY_INFO ) ;
		this.usuario = new Usuario() ;
		
		return "novoUser" ;
	}
	
	private void addMessage( String message , Severity severity ) {
		FacesMessage fm = new FacesMessage( message ) ;
		FacesContext fc = FacesContext.getCurrentInstance() ;
		fm.setSeverity( severity ) ;
		fc.addMessage( null , fm ) ;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the senhaConf
	 */
	public String getSenhaConf() {
		return senhaConf;
	}

	/**
	 * @param senhaConf the senhaConf to set
	 */
	public void setSenhaConf(String senhaConf) {
		this.senhaConf = senhaConf;
	}
	
}
