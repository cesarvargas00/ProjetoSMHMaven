package br.edu.mackenzie.projetoSMHMaven.beans;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import net.sf.textile4j.Textile;

import br.edu.mackenzie.projetoSMHMaven.model.Post;
import br.edu.mackenzie.projetoSMHMaven.repositorios.PostRepositorio;
import br.edu.mackenzie.projetoSMHMaven.repositorios.UsuarioRepositorio;
import br.edu.mackenzie.projetoSMHMaven.util.SessaoUsuario;

@ManagedBean( name = "editpost" )
public class EditPostBean {

	public Long postId ;

	private Post post ;
	
	public EditPostBean() {
		this.post = new Post() ;
	}

	public String editPost() {
		if ( ! SessaoUsuario.getInstance().isLogged() || ! SessaoUsuario.getInstance().getUser().isAdmin() ) {
			return "index" ;
		}
		
		PostRepositorio repo = new PostRepositorio() ;
		this.post = repo.getById( this.postId ) ;
		if ( this.post == null ) {
			return "index" ;
		}

		return "/admin/editpost" ;
	}

	public String savePost() {
		if ( ! SessaoUsuario.getInstance().isLogged() || ! SessaoUsuario.getInstance().getUser().isAdmin() ) {
			return "index" ;
		}
		
		this.post.setOwner(SessaoUsuario.getInstance().getUser()) ; 

		if ( this.post.getTitle().equals( "" ) ) {
			this.addMessage( "Título vazio" , FacesMessage.SEVERITY_WARN ) ;
			return "editpost" ;
		}
		
		String content = this.post.getContentTextile() ;
		content = content.trim() ;
		
		if ( content.equals( "" ) ) {
			this.addMessage( "Conteudo vazio" , FacesMessage.SEVERITY_WARN ) ;
			return "editpost" ;
		}
		
		System.out.println( this.post ) ;

		Textile textile = new Textile() ;
		String htmlContent = textile.process( content ).trim() ;
		this.post.setContent( htmlContent ) ;
		this.post.setContentTextile( content ) ;

		this.addMessage( "Postagem salva" , FacesMessage.SEVERITY_INFO ) ;

		return "index" ;
	}

	private void addMessage( String message , Severity severity ) {
		FacesMessage fm = new FacesMessage( message ) ;
		FacesContext fc = FacesContext.getCurrentInstance() ;
		fm.setSeverity( severity ) ;
		fc.addMessage( null , fm ) ;
	}

	/**
	 * @return the postId
	 */
	public Long getPostId() {
		return postId ;
	}

	/**
	 * @param postId the postId to set
	 */
	public void setPostId( Long postId ) {
		this.postId = postId ;
	}

	public Post getPost() {
		return this.post ;
	}

	public void setPost( Post post ) {
		this.post = post ;
	}
}
