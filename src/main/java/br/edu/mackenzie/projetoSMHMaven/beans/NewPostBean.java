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
	
	private Post post ;
	
	private String conteudo ;
	
	public NewPostBean() {
		this.post = new Post() ;
	}
	
	public String incluiPost() {
		String title = this.post.getTitle() ;
		title = title.trim() ;
		
		if ( title.equals( "" ) ) {
			this.addMessage( "Título vazio" , FacesMessage.SEVERITY_WARN ) ;
			return "newpost" ;
		}
		
		String content = this.post.getContent() ;
		content = content.trim() ;
		
		if ( content.equals( "" ) ) {
			this.addMessage( "Conteudo vazio" , FacesMessage.SEVERITY_WARN ) ;
			return "newpost" ;
		}
		
		Textile textile = new Textile() ;
		String htmlContent = textile.process( content ).trim() ;
		this.post.setContent( htmlContent ) ;
		this.post.setOwner(this.getUsuarioLogado()) ;
		this.post.setDateOfCreation(Calendar.getInstance()) ;
		
		PostRepositorio repo = new PostRepositorio() ;
		repo.persistir( post ) ;
		
		this.addMessage( "Post incluido.." , FacesMessage.SEVERITY_INFO ) ;
		
		this.post = new Post() ;
		return "newpost" ;
	}
	
	private void addMessage( String message , Severity severity ) {
		FacesMessage fm = new FacesMessage( message ) ;
		FacesContext fc = FacesContext.getCurrentInstance() ;
		fm.setSeverity( severity ) ;
		fc.addMessage( null , fm ) ;
	}
	
	private Usuario getUsuarioLogado() {
		return SessaoUsuario.getInstance().getUser() ;
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

	/**
	 * @return the post
	 */
	public Post getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(Post post) {
		this.post = post;
	}	
}
