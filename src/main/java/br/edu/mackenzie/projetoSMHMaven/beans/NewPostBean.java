package br.edu.mackenzie.projetoSMHMaven.beans;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.mackenzie.projetoSMHMaven.model.Post;
import br.edu.mackenzie.projetoSMHMaven.model.Usuario;
import br.edu.mackenzie.projetoSMHMaven.repositorios.PostRepositorio;
import br.edu.mackenzie.projetoSMHMaven.util.SessaoUsuario;

import net.sf.textile4j.Textile;

@ManagedBean( name = "newpost" )
public class NewPostBean {
	
	private String conteudo ;
	
	public void incluiPost() {
		this.conteudo = this.conteudo.trim() ;
		if ( this.conteudo.equals( "" ) ) {
			this.addMessage( "Conteudo vazio" , FacesMessage.SEVERITY_WARN ) ;
		}
		
		Textile textile = new Textile() ;
		String conteudoProcess = textile.process( this.conteudo ).trim() ;
		
		PostRepositorio repo = new PostRepositorio() ;
		Post post = new Post() ;
		post.setContent( conteudoProcess ) ;
		post.setOwner(this.getUsuarioLogado()) ;
		post.setDateOfCreation(Calendar.getInstance()) ;
		
		repo.persistir(post) ;
		
		this.addMessage( "Post incluido.." , FacesMessage.SEVERITY_INFO ) ;
	}
	
	private void addMessage( String message , Severity severity ) {
		FacesMessage fm = new FacesMessage( message ) ;
		FacesContext fc = FacesContext.getCurrentInstance() ;
		fm.setSeverity( severity ) ;
		fc.addMessage( null , fm ) ;
	}
	
	private Usuario getUsuarioLogado() {
		SessaoUsuario sessaoUsuario = new SessaoUsuario() ;
		return sessaoUsuario.getUser() ;
	}

	/**
	 * @return the conteudo
	 */
	public String getConteudo() {
		return conteudo;
	}

	/**
	 * @param conteudo the conteudo to set
	 */
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}	
}
